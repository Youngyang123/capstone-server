package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.User;
import cn.yg.capstoneserver.entity.UserFocus;
import cn.yg.capstoneserver.mapper.UserFocusMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserFocusBiz extends BaseBiz<UserFocusMapper, UserFocus> {

    private UserBiz userBiz;

    public ObjectResponseResult toggle(UserFocus userFocus) {
        User user = userBiz.selectById(userFocus.getUid());
        User fuser = userBiz.selectById(userFocus.getFid());
        if (user == null || fuser == null) {
            return ObjectResponseResult.getInstance()
                    .message("被关注的用户或者关注的用户不存在")
                    .code(40000)
                    .success(false);
        }

        if (mapper.select(userFocus).size() != 0) {
            mapper.delete(userFocus);
            return ObjectResponseResult.getInstance()
                    .message("取消关注成功");
        }

        userFocus.setCrtTime(new Date());
        mapper.insertSelective(userFocus);
        return ObjectResponseResult.getInstance()
                .message("关注成功");
    }
}
