package cn.yg.capstoneserver.mapper;

import cn.yg.capstoneserver.entity.UserFocus;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserFocusMapper extends Mapper<UserFocus> {
    List<String> getFocusIds(String uid);
}