package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.ClazzBiz;
import cn.yg.capstoneserver.entity.Clazz;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clazz")
public class ClazzController extends BaseController<ClazzBiz, Clazz> {
    @PostMapping
    public ObjectResponseResult add(@RequestBody Clazz clazz) {
        return baseBiz.add(clazz);
    }

    @GetMapping("school/{schoolId}/academy/{academyId}/major/{majorId}")
    public QueryResponseResult getBySAMId(@PathVariable int schoolId,
                                          @PathVariable int academyId,
                                          @PathVariable int majorId) {
        return baseBiz.getBySAMId(schoolId, academyId, majorId);
    }
}
