package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.AcademyBiz;
import cn.yg.capstoneserver.entity.Academy;
import cn.yg.capstoneserver.entity.vo.AcademyVo;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("academy")
public class AcademyController extends BaseController<AcademyBiz, Academy> {
    @GetMapping("vo")
    public QueryResponseResult<AcademyVo> findVos(AcademyVo academyVo, int pageSize, int pageNum) {
        return baseBiz.selectVo(academyVo, pageNum, pageSize);
    }
}
