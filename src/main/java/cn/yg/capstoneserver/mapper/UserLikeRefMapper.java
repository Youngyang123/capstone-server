package cn.yg.capstoneserver.mapper;

import cn.yg.capstoneserver.entity.UserLikeRef;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserLikeRefMapper extends Mapper<UserLikeRef> {
    List<Integer> selectAids(String uid);
}