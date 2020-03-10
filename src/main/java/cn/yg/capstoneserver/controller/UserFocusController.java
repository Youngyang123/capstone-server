package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.UserFocusBiz;
import cn.yg.capstoneserver.entity.UserFocus;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("focus")
public class UserFocusController extends BaseController<UserFocusBiz, UserFocus> {

    @PostMapping("toggle")
    public ObjectResponseResult toggle(@RequestBody UserFocus userFocus) {
        return baseBiz.toggle(userFocus);
    }


}
