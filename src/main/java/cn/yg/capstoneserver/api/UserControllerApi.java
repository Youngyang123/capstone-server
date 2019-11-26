package cn.yg.capstoneserver.api;

import cn.yg.capstoneserver.entity.User;
import cn.yg.capstoneserver.utils.request.LoginRequest;
import cn.yg.capstoneserver.utils.response.LoginResponseResult;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.ResponseResult;
import io.swagger.annotations.*;

@Api(value = "用户权限", description = "用户登录/用户信息/用户退出")
public interface UserControllerApi {
    @ApiOperation("用户登录")
    LoginResponseResult login(LoginRequest loginRequest);

    @ApiOperation("获取用户信息")
    ObjectResponseResult<User> info(int id);

    @ApiOperation("用户退出")
    ResponseResult logout(int id);

    @ApiOperation("用户注册")
    ResponseResult regist(User user);


}

