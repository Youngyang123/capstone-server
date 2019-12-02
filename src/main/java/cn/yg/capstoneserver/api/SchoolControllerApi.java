package cn.yg.capstoneserver.api;

import cn.yg.capstoneserver.entity.School;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

@Api(value = "学校模块api", description = "学校模块api")
public interface SchoolControllerApi {
    @ApiOperation("添加一个学校")
    void add(School school);
    @ApiOperation("删除一个学校")
    void deleteByid(int id);
    @ApiOperation("更新学校信息")
    void update(School school);
    @ApiOperation("分页查询")
    QueryResponseResult<School> page(Map<String, Object> params);
}
