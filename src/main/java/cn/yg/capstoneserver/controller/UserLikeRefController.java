package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.UserLikeRefBiz;
import cn.yg.capstoneserver.entity.UserLikeRef;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("like")
@CrossOrigin
public class UserLikeRefController extends BaseController<UserLikeRefBiz, UserLikeRef> {

    @PostMapping("toggle")
    public ObjectResponseResult toggle(@RequestBody UserLikeRef userLikeRef) {
        return baseBiz.toggle(userLikeRef);
    }
}
