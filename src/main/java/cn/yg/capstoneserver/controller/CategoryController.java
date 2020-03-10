package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.CategoryBiz;
import cn.yg.capstoneserver.entity.Category;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
public class CategoryController extends BaseController<CategoryBiz, Category> {

    @GetMapping("tree")
    public ObjectResponseResult getTree() {
        return baseBiz.getTree();
    }

    @PostMapping
    public ObjectResponseResult<Category> add(@RequestBody Category category){
        return baseBiz.add(category);
    }

    @DeleteMapping("{id}")
    @Override
    public ObjectResponseResult<Category> remove(@PathVariable int id){
        return baseBiz.delCategory(id);
    }
}
