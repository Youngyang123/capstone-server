package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.api.TestControllerApi;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController implements TestControllerApi {
    @Override
    @PostMapping
    public ObjectResponseResult test1(int param1, String param2) {
        System.out.println(param1+ "  " + param2);
        ObjectResponseResult<String> objectResponseResult = new ObjectResponseResult<>(2000,"success", "数据");
        return objectResponseResult;
    }
}
