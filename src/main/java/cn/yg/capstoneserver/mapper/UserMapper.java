package cn.yg.capstoneserver.mapper;

import cn.yg.capstoneserver.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    List<User> getMyFocus(String uid);
    List<User> getFocusMe(String fid);
}