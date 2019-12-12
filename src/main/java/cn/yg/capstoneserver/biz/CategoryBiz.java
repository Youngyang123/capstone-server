package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Category;
import cn.yg.capstoneserver.entity.vo.CategoryVo;
import cn.yg.capstoneserver.mapper.CategoryMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryBiz extends BaseBiz<CategoryMapper, Category> {

    public ObjectResponseResult getTree() {

        Category root = mapper.selectByPrimaryKey(-1);
        if (root == null) {
            throw new RuntimeException("获取根节点失败，请联系管理员");
        }
        CategoryVo rootVo = new CategoryVo();
        BeanUtils.copyProperties(root, rootVo);
        List<CategoryVo> children = getByPid(-1);
        rootVo.setChildren(children);
        return ObjectResponseResult.getInstance()
                .data(rootVo);

    }

    private List<CategoryVo> getByPid(int id) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pid", id);
        List<Category> categories = mapper.selectByExample(example);
        if (categories == null || categories.isEmpty()) {
            return new ArrayList<>();
        }
        List<CategoryVo> categoryVos = new ArrayList<>();
        categories.forEach(category -> {
            CategoryVo categoryVo = new CategoryVo();
            BeanUtils.copyProperties(category, categoryVo);
            List<CategoryVo> children = getByPid(category.getId());
            categoryVo.setChildren(children);
            categoryVos.add(categoryVo);
        });
        return categoryVos;
    }

    public ObjectResponseResult<Category> add(Category category) {
        if (mapper.selectByPrimaryKey(category.getPid()) == null) {
            return ObjectResponseResult.getInstance()
                    .success(false)
                    .message("父节点id不存在");
        }

        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", category.getName());
        if (!mapper.selectByExample(example).isEmpty()) {
            return ObjectResponseResult.getInstance()
                    .message("该分类名称已经存在")
                    .success(false);
        }
        mapper.insertSelective(category);
        return ObjectResponseResult.getInstance()
                .success(true)
                .message("添加分类成功");
    }

    public ObjectResponseResult<Category> delCategory(int id) {
        if(mapper.selectByPrimaryKey(id) == null) {
            return ObjectResponseResult.getInstance()
                    .message("该分类不存在")
                    .success(false);
        }

        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pid", id);
        List<Category> categories = mapper.selectByExample(example);
        if(!categories.isEmpty()) {
            return ObjectResponseResult.getInstance()
                    .success(false)
                    .message("该分类下还有子分类，不能删除");
        }

        mapper.deleteByPrimaryKey(id);
        return ObjectResponseResult.getInstance()
                .message("删除分类成功");
    }
}
