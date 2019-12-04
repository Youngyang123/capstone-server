package cn.yg.capstoneserver.mapper;

import cn.yg.capstoneserver.entity.Academy;
import cn.yg.capstoneserver.entity.vo.AcademyVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AcademyMapper extends Mapper<Academy> {
    List<AcademyVo> selectVo(AcademyVo academyVo);
}