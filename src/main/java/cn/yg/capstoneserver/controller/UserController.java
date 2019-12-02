package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.api.UserControllerApi;
import cn.yg.capstoneserver.biz.UserBiz;
import cn.yg.capstoneserver.entity.vo.UserVo;
import cn.yg.capstoneserver.utils.request.LoginRequest;
import cn.yg.capstoneserver.utils.response.LoginResponseResult;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import cn.yg.capstoneserver.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
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
    public ObjectResponseResult<UserVo> info(@PathVariable String id) {
        return userBiz.info(id);
    }

    @Override
    @GetMapping("logout/{id}")
    public ResponseResult logout(@PathVariable String id) {
        return userBiz.logout(id);
    }



}
