package cn.yg.capstoneserver.api;

import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "swagger测试", description = "测试swagger")
public interface TestControllerApi {

    @ApiOperation("测试test1接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="param1",value = "测试参数1",required=true,dataType="int"),
            @ApiImplicitParam(name="param2",value = "每页记录 数",required=true)
    })
    ObjectResponseResult test1(int param1, String param2);



}
