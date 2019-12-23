package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.UserCollectionBiz;
import cn.yg.capstoneserver.entity.UserCollection;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("collection")
@CrossOrigin
public class UserCollectionController extends BaseController<UserCollectionBiz, UserCollection> {
    @PostMapping("toggle")
    public ObjectResponseResult toggle(@RequestBody UserCollection userCollection) {
        return baseBiz.toggle(userCollection);
    }
}
