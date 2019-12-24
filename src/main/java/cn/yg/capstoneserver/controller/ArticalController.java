package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.ArticalBiz;
import cn.yg.capstoneserver.entity.Artical;
import cn.yg.capstoneserver.utils.Query;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("artical")
@CrossOrigin
public class ArticalController extends BaseController<ArticalBiz, Artical> {

    @PostMapping
    public ObjectResponseResult<Artical> add(@RequestBody Artical entity) {

        return baseBiz.add(entity);
    }

    @GetMapping("list")
    public QueryResponseResult articalList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        return baseBiz.detailList(query);
    }

    @GetMapping("teacher")
    public QueryResponseResult teacherArtical(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        return baseBiz.getTeacherArtical(query);
    }

    @GetMapping("major")
    public QueryResponseResult getMajorArtical(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        return baseBiz.getMajorArtical(query);
    }

    @GetMapping("collection")
    public ObjectResponseResult getCollection(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        return baseBiz.selectCollection(query);
    }
}
