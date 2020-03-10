package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.api.UserControllerApi;
import cn.yg.capstoneserver.biz.ImportUserBiz;
import cn.yg.capstoneserver.biz.UserBiz;
import cn.yg.capstoneserver.entity.ImportUser;
import cn.yg.capstoneserver.entity.Major;
import cn.yg.capstoneserver.entity.User;
import cn.yg.capstoneserver.mapper.UserMapper;
import cn.yg.capstoneserver.utils.FtpUtil;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.request.LoginRequest;
import cn.yg.capstoneserver.utils.response.LoginResponseResult;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import cn.yg.capstoneserver.utils.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserBiz, User> implements UserControllerApi {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserBiz userBiz;

    @Autowired
    private ImportUserBiz importUserBiz;

    @Override
    @PostMapping("login")
    public LoginResponseResult login(@RequestBody LoginRequest loginRequest) {
        return userBiz.login(loginRequest.getId(), loginRequest.getPasswd());
    }

    @Override
    @GetMapping("info/{id}")
    public ObjectResponseResult<User> info(@PathVariable String id) {
        return userBiz.info(id);
    }

    @Override
    @GetMapping("logout/{id}")
    public ResponseResult logout(@PathVariable String id) {
        return userBiz.logout(id);
    }

    @PostMapping
    public ObjectResponseResult add(@RequestBody User user) {
        return userBiz.add(user);
    }

    @GetMapping("myFocus")
    public QueryResponseResult getMyFocus(@RequestParam Map<String, Object> params) {
        return baseBiz.getMyFocus(params);
    }

    @GetMapping("focusMe")
    public QueryResponseResult getFocusMe(@RequestParam Map<String, Object> params) {
        return baseBiz.getFocusMe(params);
    }

    @PostMapping("import")
    public ObjectResponseResult upload(MultipartFile file) throws IOException {

        String fileHead = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String originalFilename = file.getOriginalFilename();
        String host = "106.54.95.152";
        // 上传文件
        boolean success = FtpUtil.uploadFile(host, 21, "ftpuser",
                "123456", "/home/ftpuser", "/", fileHead + originalFilename, file.getInputStream());
        if (!success) {
            logger.error("-----上传图片失败------");
            System.out.println("-----上传图片失败------");
            return ObjectResponseResult.getInstance()
                    .success(false)
                    .code(40000)
                    .message("上传失败");
        }
        String fileUrl = "http://" + host + "/" + fileHead + originalFilename;
        ImportUser importUser = new ImportUser();
        importUser.setCrtTime(new Date());
        importUser.setFileHead(fileHead);
        importUser.setFileName(originalFilename);
        // 正在上传
        importUser.setStatus(1);
        importUser.setFileUrl(fileUrl);
        importUser.setRemark("正在上传");
        importUserBiz.insertSelective(importUser);
        baseBiz.importExcel(file.getInputStream(), importUser);
        logger.info("-----上传图片成功------");
        return ObjectResponseResult.getInstance()
                .message("上传成功，请在导入进度查看");

    }

    @PutMapping
    @Override
    public ObjectResponseResult update(@RequestBody User user) {
        User userUpd = baseBiz.selectById(user.getId());
        if (userUpd == null) {
            return ObjectResponseResult.getInstance()
                    .message("用户不存在")
                    .success(false)
                    .code(40000);
        }
        if (user.getPasswd() != null) {
            userUpd.setPasswd(user.getPasswd());
        }

        if (user.getPhoto() != null) {
            userUpd.setPhoto(user.getPhoto());
        }
        userUpd.setNickName(user.getNickName());
        baseBiz.updateById(userUpd);
        return ObjectResponseResult.getInstance()
                .message("修改成功");
    }
}
