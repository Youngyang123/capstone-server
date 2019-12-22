package cn.yg.capstoneserver.utils.biz;

import cn.yg.capstoneserver.utils.Query;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Column;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public class BaseBiz<M extends Mapper<T>, T> {
    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }


    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }


    public List<T> selectListAll() {
        return mapper.selectAll();
    }


    public Long selectCount(T entity) {
        return (long) mapper.selectCount(entity);
    }


    public void insert(T entity) {
        mapper.insert(entity);
    }


    public void insertSelective(T entity) {
        mapper.insertSelective(entity);
    }


    public void delete(T entity) {
        mapper.delete(entity);
    }


    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }


    public void updateById(T entity) {
        mapper.updateByPrimaryKey(entity);
    }


    public void updateSelectiveById(T entity) {
        mapper.updateByPrimaryKeySelective(entity);

    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    public QueryResponseResult<T> selectByQuery(Query query) {
        // 获得类型
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key.contains("_")){
                    String[] s = key.split("_");
                    if(s.length != 2) {
                        throw new RuntimeException("请求参数最多自能包含一个字符：[_]");
                    }
                    // 等于
                    if (s[1].equals("eq")){
                        criteria.andEqualTo(s[0], value);
                        continue;
                    }

                    if (s[1].equals("like")) {
                        criteria.andLike(s[0], "%" + value.toString() + "%");
                        continue;
                    }

                    throw new RuntimeException("现在暂时不支持[" + s[1] +"]");
                }

                if ("sort".equals(key)) {
                    try {
                        Column annotation = clazz.getDeclaredField(value.toString()).getAnnotation(Column.class);
                        if (annotation == null) {
                            example.setOrderByClause(value.toString() + " DESC");
                        }else {
                            example.setOrderByClause(annotation.name() + " DESC");
                        }
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                        throw new RuntimeException("没有发现这个字段:"+ "[" + value.toString() +"]");
                    }

                }

            }
        }

        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<T> list = mapper.selectByExample(example);
        PageInfo<T> pageInfo = new PageInfo<>(list);
        QueryResponseResult<T> queryResponseResult = new QueryResponseResult<>(list, pageInfo.getTotal());
        return queryResponseResult;
    }

}
