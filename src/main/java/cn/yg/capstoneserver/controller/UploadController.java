package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.api.UploadControllerApi;
import cn.yg.capstoneserver.utils.FtpUtil;
import cn.yg.capstoneserver.utils.IDUtils;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class UploadController implements UploadControllerApi {

    private static Logger logger = LoggerFactory.getLogger(UploadController.class);


    @Override
    @PostMapping("posts")
    public ObjectResponseResult<String> posts(MultipartFile file) {
        try {

            String originalFilename = file.getOriginalFilename();
            String fileName = IDUtils.genImageName() + originalFilename.substring(originalFilename.lastIndexOf("."));
            String host = "106.54.95.152";
            // 上传文件
            boolean success = FtpUtil.uploadFile(host, 21, "ftpuser",
                    "123456", "/home/ftpuser", "/", fileName, file.getInputStream());
            if (!success) {
                logger.error("-----上传图片失败------");
                System.out.println("-----上传图片失败------");
                throw new RuntimeException("上传失败");
            }

            String imageUrl = "http://" + host  + "/" + fileName;
            logger.error("-----上传图片成功------");
            System.out.println("-----上传图片成功------");

            return new ObjectResponseResult<>(20000, "上传成功", imageUrl);
        }catch (Exception e) {
            e.printStackTrace();
            return new ObjectResponseResult<>(40000, "上传失败", null);
        }
    }
}
