package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.*;
import cn.yg.capstoneserver.mapper.UserMapper;
import cn.yg.capstoneserver.utils.Query;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.LoginResponseResult;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import cn.yg.capstoneserver.utils.response.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
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
    @Autowired
    private ImportUserBiz importUserBiz;
    
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

    @Async
    public void importExcel(InputStream in, ImportUser importUser) throws IOException {
        try {
            XSSFWorkbook wb = new XSSFWorkbook(in);
            Sheet sheet = wb.getSheetAt(0);
            importUser.setStatus(2);
            int rows = sheet.getLastRowNum();
            for (int i=2; i<=rows; i++) {
                Row row = sheet.getRow(i);
                User user = new User();
                user.setId(row.getCell(1).toString());
                user.setName(row.getCell(2).toString());
                user.setPasswd(row.getCell(3).toString());
                int age = Integer.parseInt(row.getCell(4).toString());
                user.setAge(age);
                // 学校
                int schoolId = Integer.parseInt(row.getCell(5).toString());
                School school = schoolBiz.selectById(schoolId);
                if (school == null) {
                    String remark = "第"+ i + "行，" + "第5列学校代号不存在";
                    importUser.setStatus(3);
                    importUser.setRemark(remark);
                    break;
                }
                user.setSchoolId(schoolId);
                user.setSchoolName(school.getName());
                // 学院
                int academyId = Integer.parseInt(row.getCell(6).toString());
                Academy academy = academyBiz.selectById(academyId);
                if (academy == null) {
                    String remark = "第"+ i + "行，" + "第6列学院代号不存在";
                    importUser.setStatus(3);
                    importUser.setRemark(remark);
                    return;
                }
                user.setAcademyId(academyId);
                user.setAcademyName(academy.getName());

                // 专业
                int majorId = Integer.parseInt(row.getCell(7).toString());
                Major major = majorBiz.selectById(majorId);
                if (major == null) {
                    String remark = "第"+ i + "行，" + "第7列专业代号不存在";
                    importUser.setStatus(3);
                    importUser.setRemark(remark);
                    return;
                }
                user.setMajorId(majorId);
                user.setMajorName(major.getName());

                // 班级
                int clazzId = Integer.parseInt(row.getCell(8).toString());
                Clazz clazz = clazzBiz.selectById(clazzId);
                if (clazz == null) {
                    String remark = "第"+ i + "行，" + "第8列班级代号不存在";
                    importUser.setStatus(3);
                    importUser.setRemark(remark);
                    return;
                }
                user.setClazzId(clazzId);
                user.setClazzName(clazz.getName());

                // 身份
                int identity = Integer.parseInt(row.getCell(9).toString());
                if (identity != 1 && identity != 2) {
                    String remark = "第"+ i + "行，" + "第9列身份代号不存在";
                    importUser.setStatus(3);
                    importUser.setRemark(remark);
                    return;
                }
                user.setIdentity(identity);

                // 加到数据库
                this.insertSelective(user);
            }
        }finally {
            importUserBiz.updateById(importUser);
        }
    }
}
