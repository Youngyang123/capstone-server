package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Academy;
import cn.yg.capstoneserver.entity.vo.AcademyVo;
import cn.yg.capstoneserver.mapper.AcademyMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AcademyBiz extends BaseBiz<AcademyMapper, Academy> {
    public QueryResponseResult<AcademyVo> selectVo(AcademyVo vo, int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<AcademyVo> academyVos = mapper.selectVo(vo);
        PageInfo<AcademyVo> pageInfo = new PageInfo<>(academyVos);
        QueryResponseResult<AcademyVo> result = new QueryResponseResult<>(pageInfo.getList(), pageInfo.getTotal());
        return result;
    }

}
