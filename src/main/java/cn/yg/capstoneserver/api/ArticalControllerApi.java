package cn.yg.capstoneserver.api;

import cn.yg.capstoneserver.entity.vo.ArticalVo;
import cn.yg.capstoneserver.utils.request.ArticalRequest;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "文章模块", description = "关于文章的接口")
public interface ArticalControllerApi {
    @ApiOperation("按最新时间获得文章")
    QueryResponseResult<ArticalVo> getByTime();
    @ApiOperation("按点赞数获得文章")
    QueryResponseResult<ArticalVo> getByLike();
    @ApiOperation("根据文章id获得文章详细内容")
    QueryResponseResult<ArticalVo> getArticalDetail(Integer id);
    @ApiOperation(value = "发布文章")
    ObjectResponseResult publishArtical(ArticalRequest articalRequest);
}
