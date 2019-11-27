package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.api.SysAdminControllerApi;
import cn.yg.capstoneserver.utils.request.SysAdminRequest;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.ResponseResult;
import cn.yg.capstoneserver.utils.response.SysLoginResponseResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("sys")
@CrossOrigin
public class SysAdminController implements SysAdminControllerApi {
    @PostMapping("login")
    public SysLoginResponseResult login(@RequestBody SysAdminRequest sysAdminRequest) {
        if (!"admin".equals(sysAdminRequest.getUsername()) && !"123456".equals(sysAdminRequest.getPassword())) {
            //
            return new SysLoginResponseResult(23005, "账号或密码错误", null);
        }
        String token = "admin-token";
        return new SysLoginResponseResult(10000, "登录成功", token);
    }

    @GetMapping("info/{token}")
    public ObjectResponseResult<Map<String, String>> info(@PathVariable String token) {
        if (!"admin-token".equals(token)) {
            new ObjectResponseResult<>(21200, "token错误", null);
        }
        Map<String, String> map = new HashMap<>();
        map.put("name", "young");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return new ObjectResponseResult<>(10000, "success", map);
    }

    @PostMapping("logout/{token}")
    public ResponseResult logout(@PathVariable String token) {
        if (!"admin-token".equals(token)) {
            return new ResponseResult(11111, "失败" );
        }
        return new ResponseResult(10000, "退出成功");
    }
}
