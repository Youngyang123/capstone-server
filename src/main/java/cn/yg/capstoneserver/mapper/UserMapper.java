package cn.yg.capstoneserver.mapper;

import cn.yg.capstoneserver.entity.User;
import cn.yg.capstoneserver.entity.vo.UserVo;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    UserVo selectUserVoById(String id);
}
