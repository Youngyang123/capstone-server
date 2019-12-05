package cn.yg.capstoneserver.utils.controller;

import cn.yg.capstoneserver.utils.Query;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class BaseController<Biz extends BaseBiz,Entity> {
    @Autowired
    protected Biz baseBiz;

    @PostMapping
    @ResponseBody
    public ObjectResponseResult<Entity> add(@RequestBody Entity entity){
        baseBiz.insertSelective(entity);
        return new ObjectResponseResult<>();
    }

    @GetMapping("{id}")
    @ResponseBody
    public ObjectResponseResult<Entity> get(@PathVariable int id){
        Entity entity = (Entity)baseBiz.selectById(id);
        ObjectResponseResult<Entity> objectResponseResult = new ObjectResponseResult<>();
        objectResponseResult.setData(entity);
        return objectResponseResult;
    }

    @PutMapping("{id}")
    @ResponseBody
    public ObjectResponseResult<Entity> update(@RequestBody Entity entity){
        baseBiz.updateSelectiveById(entity);
        return new ObjectResponseResult<>();
    }
    @DeleteMapping("{id}")
    @ResponseBody
    public ObjectResponseResult<Entity> remove(@PathVariable int id){
        baseBiz.deleteById(id);
        return new ObjectResponseResult<>();
    }

    @GetMapping("all")
    @ResponseBody
    public QueryResponseResult<Entity> all(){
        List list = baseBiz.selectListAll();
        return new QueryResponseResult<Entity>(list, list.size());
    }
    @GetMapping("page")
    @ResponseBody
    public QueryResponseResult<Entity> list(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        return baseBiz.selectByQuery(query);
    }
}
