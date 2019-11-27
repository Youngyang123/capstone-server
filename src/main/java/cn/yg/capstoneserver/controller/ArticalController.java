package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.api.ArticalControllerApi;
import cn.yg.capstoneserver.biz.ArticalBiz;
import cn.yg.capstoneserver.entity.Artical;
import cn.yg.capstoneserver.entity.vo.ArticalVo;
import cn.yg.capstoneserver.utils.request.ArticalRequest;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("artical")
@CrossOrigin
public class ArticalController implements ArticalControllerApi {

    @Autowired
    private ArticalBiz articalBiz;


    @Override
    @GetMapping("time")
    public QueryResponseResult<ArticalVo> getByTime() {
        return articalBiz.getByTime();
    }

    @Override
    @GetMapping("like")
    public QueryResponseResult<ArticalVo> getByLike() {
        return null;
    }

    @Override
    @GetMapping("detail")
    public QueryResponseResult<ArticalVo> getArticalDetail(Integer id) {
        return null;
    }

    @Override
    @PostMapping
    public ObjectResponseResult publishArtical(@RequestBody  ArticalRequest articalRequest) {
        return null;
    }
}
