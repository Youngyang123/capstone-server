package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Major;
import cn.yg.capstoneserver.entity.User;
import cn.yg.capstoneserver.entity.UserCollection;
import cn.yg.capstoneserver.mapper.UserCollectionMapper;
import cn.yg.capstoneserver.mapper.UserLikeRefMapper;
import cn.yg.capstoneserver.mapper.UserMapper;
import cn.yg.capstoneserver.utils.Query;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.LoginResponseResult;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import cn.yg.capstoneserver.utils.response.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class UserBiz extends BaseBiz<UserMapper, User> {

    @Autowired
    private SchoolBiz schoolBiz;
    @Autowired
    private AcademyBiz academyBiz;
    @Autowired
    private MajorBiz majorBiz;
    @Autowired
    private ClazzBiz clazzBiz;
    
    public QueryResponseResult findAll() {
        List<User> users = mapper.selectAll();
        QueryResponseResult<User> queryResponseResult = new QueryResponseResult<>("success", users, users.size());
        return queryResponseResult;
    }


    public ResponseResult logout(String id) {
        return new ResponseResult("退出成功");
    }

    public ObjectResponseResult<User> info(String id) {
        User user = mapper.selectByPrimaryKey(id);
        if (user == null) {
            return new ObjectResponseResult<>(40000, "用户不存在", null);
        }
        return new ObjectResponseResult<>(20000, "获取成功", user);
    }

    public LoginResponseResult login(String id, String passwd) {
        User user = new User();
        user.setId(id);
        user.setPasswd(passwd);
        List<User> users = mapper.select(user);
        if (users==null || users.size() < 1) {
            return new LoginResponseResult(40000, "用户名或密码错误", null);
        }
        return new LoginResponseResult(20000, "登录成功", users.get(0).getId());
    }

    public ObjectResponseResult add(User user) {
        if(mapper.selectByPrimaryKey(user.getId()) != null) {
            return new ObjectResponseResult()
                    .success(false)
                    .message("该工号已存在");
        }
        user.setSchoolName(schoolBiz.selectById(user.getSchoolId()).getName());
        user.setAcademyName(academyBiz.selectById(user.getAcademyId()).getName());
        user.setMajorName(majorBiz.selectById(user.getMajorId()).getName());
        user.setClazzName(clazzBiz.selectById(user.getClazzId()).getName());
        mapper.insert(user);
        return new ObjectResponseResult().message("录入成功");
    }

    public QueryResponseResult getMyFocus(Map<String, Object> params) {
        Query query = new Query(params);
        String uid = (String) params.get("uid");
        if (uid == null) {
            throw new RuntimeException("没有uid");
        }
//        System.out.println(query.getPageNum() +" size: " + query.getPageSize());
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<User> myFocus = mapper.getMyFocus(uid);
        PageInfo<User> pageInfo = new PageInfo<>(myFocus);
        return QueryResponseResult.getInstance()
                .data(pageInfo.getList())
                .total(pageInfo.getTotal());
    }

    public QueryResponseResult getFocusMe(Map<String, Object> params) {
        Query query = new Query(params);
        String fid = (String) params.get("fid");
        if (fid == null) {
            throw new RuntimeException("没有fid");
        }
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<User> focusMe = mapper.getFocusMe(fid);
        PageInfo<User> pageInfo = new PageInfo<>(focusMe);
        return QueryResponseResult.getInstance()
                .data(pageInfo.getList())
                .total(pageInfo.getTotal());
    }
}
