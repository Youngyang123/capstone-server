package cn.yg.capstoneserver.api;

import cn.yg.capstoneserver.utils.request.SysAdminRequest;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.ResponseResult;
import cn.yg.capstoneserver.utils.response.SysLoginResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface SysAdminControllerApi {
    @ApiOperation("登陆")
    SysLoginResponseResult login(SysAdminRequest sysAdminRequest);

    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name="token", value = "验证用户的令牌", required = true, paramType = "path")
    ObjectResponseResult<Map<String, String>> info(String token);

    @ApiOperation("用户退出")
    @ApiImplicitParam(name="token", value = "对应用户的令牌", required = true, paramType = "path")
    ResponseResult logout(@RequestBody String token);
}
