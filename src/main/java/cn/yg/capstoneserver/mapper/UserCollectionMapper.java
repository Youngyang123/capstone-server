package cn.yg.capstoneserver.mapper;

import cn.yg.capstoneserver.entity.UserCollection;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserCollectionMapper extends Mapper<UserCollection> {
    List<Integer> selectAids(String uid);
}