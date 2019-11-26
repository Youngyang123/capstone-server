package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.User;
import cn.yg.capstoneserver.mapper.UserMapper;
import cn.yg.capstoneserver.utils.response.LoginResponseResult;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import cn.yg.capstoneserver.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBiz {
    @Autowired
    private UserMapper userMapper;

    public QueryResponseResult findAll() {
        List<User> users = userMapper.selectAll();
        QueryResponseResult<User> queryResponseResult = new QueryResponseResult<>("success", users, users.size());
        return queryResponseResult;
    }

    public ObjectResponseResult<User> addUser(User user) {
        if(user.getId() == null) {
            return new ObjectResponseResult<>(40000, "用户工号不能为空", null);
        }
        userMapper.insert(user);
        return new ObjectResponseResult<>(20000, "添加成功", null);
    }

    public ResponseResult regist(User user) {
        if(user.getId() == null) {
            return new ResponseResult(40000, "用户工号不能为空");
        }
        if(userMapper.selectByPrimaryKey(user.getId()) != null) {
            return new ResponseResult(40000, "工号已存在");
        }
        userMapper.insert(user);
        return new ResponseResult(20000, "添加成功");
    }

    public ResponseResult logout(int id) {
        return new ResponseResult("退出成功");
    }

    public ObjectResponseResult<User> info(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            return new ObjectResponseResult<>(40000, "用户不存在", null);
        }
        return new ObjectResponseResult<User>(20000, "获取成功", user);
    }

    public LoginResponseResult login(Integer id, String passwd) {
        User user = new User();
        user.setId(id);
        user.setPasswd(passwd);
        List<User> users = userMapper.select(user);
        if (users==null || users.size() < 1) {
            return new LoginResponseResult(40000, "用户名或密码错误", null);
        }
        return new LoginResponseResult(40000, "登录成功", users.get(0).getId());
    }
}
