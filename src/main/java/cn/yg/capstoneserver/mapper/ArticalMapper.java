package cn.yg.capstoneserver.mapper;

import cn.yg.capstoneserver.entity.Artical;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticalMapper extends Mapper<Artical> {
    List<Artical> selectByIdentity(int identity);

    List<Artical> selectByMid(int mid);
}