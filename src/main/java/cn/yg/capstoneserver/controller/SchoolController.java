package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.SchoolBiz;
import cn.yg.capstoneserver.entity.School;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("school")
public class SchoolController extends BaseController<SchoolBiz, School> {

    @PostMapping
    public ObjectResponseResult<School> add(@RequestBody School school){
        return baseBiz.add(school);
    }
}
