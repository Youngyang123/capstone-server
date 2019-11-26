package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.api.UserControllerApi;
import cn.yg.capstoneserver.biz.UserBiz;
import cn.yg.capstoneserver.entity.User;
import cn.yg.capstoneserver.utils.request.LoginRequest;
import cn.yg.capstoneserver.utils.response.LoginResponseResult;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController implements UserControllerApi {
    @Autowired
    private UserBiz userBiz;

    @Override
    @PostMapping("login")
    public LoginResponseResult login(@RequestBody LoginRequest loginRequest) {
        return userBiz.login(loginRequest.getId(), loginRequest.getPasswd());
    }

    @Override
    @GetMapping("info/{id}")
    public ObjectResponseResult<User> info(@PathVariable int id) {
        return userBiz.info(id);
    }

    @Override
    @GetMapping("logout/{id}")
    public ResponseResult logout(@PathVariable int id) {
        return userBiz.logout(id);
    }

    @Override
    @PostMapping("regist")
    public ResponseResult regist(User user) {
        return userBiz.regist(user);
    }
}
