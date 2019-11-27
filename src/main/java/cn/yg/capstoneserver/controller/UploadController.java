package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.api.UploadControllerApi;
import cn.yg.capstoneserver.utils.FtpUtil;
import cn.yg.capstoneserver.utils.IDUtils;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
@CrossOrigin
public class UploadController implements UploadControllerApi {

    @Override
    @PostMapping("posts")
    public ObjectResponseResult<String> posts(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String fileName = IDUtils.genImageName() + originalFilename.substring(originalFilename.lastIndexOf("."));
            String host = "106.54.95.152";
            // 上传文件
            FtpUtil.uploadFile(host, 21, "ftpuser",
                    "123456", "/home/ftpuser", "/", fileName, file.getInputStream());
            String imageUrl = "http://" + host  + "/" + fileName;
            return new ObjectResponseResult<>(20000, "上传成功", imageUrl);
        }catch (Exception e) {
            e.printStackTrace();
            return new ObjectResponseResult<>(40000, "上传失败", null);
        }
    }
}
