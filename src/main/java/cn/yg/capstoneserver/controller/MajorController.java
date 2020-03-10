package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.MajorBiz;
import cn.yg.capstoneserver.entity.Major;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("major")
public class MajorController extends BaseController<MajorBiz, Major> {
    @PostMapping
    public ObjectResponseResult<Major> add(@RequestBody Major major){
        return baseBiz.add(major);
    }

    @GetMapping("school/{schoolId}/academy/{academyId}")
    public QueryResponseResult getBySidAndAid(@PathVariable int schoolId, @PathVariable int academyId) {
        return baseBiz.getBySidAndAid(schoolId, academyId);
    }



}
