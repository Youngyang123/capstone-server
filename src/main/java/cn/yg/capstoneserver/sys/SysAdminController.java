package cn.yg.capstoneserver.sys;

import cn.yg.capstoneserver.api.SysAdminControllerApi;
import cn.yg.capstoneserver.utils.jwt.server.utils.JwtTokenServerUtils;
import cn.yg.capstoneserver.utils.jwt.utils.JwtInfo;
import cn.yg.capstoneserver.utils.jwt.utils.Token;
import cn.yg.capstoneserver.utils.request.SysAdminRequest;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.ResponseResult;
import cn.yg.capstoneserver.utils.response.SysLoginResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("sys")
@Transactional(rollbackFor = Exception.class)
public class SysAdminController implements SysAdminControllerApi {

    @Autowired
    private JwtTokenServerUtils jwtTokenServerUtils;

    /**
     * 管理员登陆
     * @param sysAdminRequest
     * @return
     */
    @PostMapping("login")
    public SysLoginResponseResult login(@RequestBody SysAdminRequest sysAdminRequest) {
        if (!"admin".equals(sysAdminRequest.getUsername()) && !"123456".equals(sysAdminRequest.getPassword())) {
            //
            return new SysLoginResponseResult(23005, "账号或密码错误", null);
        }
        JwtInfo jwtInfo = new JwtInfo("admin", "admin");
        Token token = jwtTokenServerUtils.generateUserToken(jwtInfo, null);
        return new SysLoginResponseResult(10000, "登录成功", token.getToken());
    }

    @GetMapping("info/{token}")
    public ObjectResponseResult<Map<String, String>> info(@PathVariable String token) {
        JwtInfo userInfo = jwtTokenServerUtils.getUserInfo(token);
        Map<String, String> map = new HashMap<>();
        map.put("name", userInfo.getName());
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return new ObjectResponseResult<>(10000, "success", map);
    }

    @PostMapping("logout/{token}")
    public ResponseResult logout(@PathVariable String token) {
        //

        return new ResponseResult(10000, "退出成功");
    }
}
