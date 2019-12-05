package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.AcademyBiz;
import cn.yg.capstoneserver.entity.Academy;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("academy")
public class AcademyController extends BaseController<AcademyBiz, Academy> {

    @PostMapping
    @ResponseBody
    public ObjectResponseResult<Academy> add(@RequestBody Academy academy){
        return baseBiz.add(academy);
    }

}
