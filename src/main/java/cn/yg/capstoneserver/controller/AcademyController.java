package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.AcademyBiz;
import cn.yg.capstoneserver.entity.Academy;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("academy")
public class AcademyController extends BaseController<AcademyBiz, Academy> {

    @PostMapping
    public ObjectResponseResult<Academy> add(@RequestBody Academy academy){
        return baseBiz.add(academy);
    }

    @GetMapping("school/{schoolId}")
    public QueryResponseResult<Academy> getBySchoolId(@PathVariable int schoolId) {
        return baseBiz.getBySchoolId(schoolId);
    }
}
