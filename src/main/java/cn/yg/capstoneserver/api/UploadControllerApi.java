package cn.yg.capstoneserver.api;

import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "图片上传", description = "用于上传图片到服务器，最后会返回图片的路径")
public interface UploadControllerApi {
    @ApiOperation("上传图片")
    @ApiImplicitParam(name = "file", value = "上传的文件", required = true, dataType = "file")
    ObjectResponseResult<String> posts(MultipartFile file);
}
