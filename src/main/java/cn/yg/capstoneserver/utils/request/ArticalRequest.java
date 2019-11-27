package cn.yg.capstoneserver.utils.request;

import io.swagger.annotations.ApiModelProperty;

public class ArticalRequest {
    @ApiModelProperty(value = "用户id")
    private String uid;
    @ApiModelProperty("文章标题")
    private String title;
    @ApiModelProperty("图片路径")
    private String imgUrl;
    @ApiModelProperty(value = "文章内容")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
