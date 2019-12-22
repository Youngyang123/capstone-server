package cn.yg.capstoneserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

public class Comment {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 文章id
     */
    @Column(name = "artical_id")
    private Integer articalId;

    /**
     * 评论内容
     */
    @Column(name = "comment_content")
    private String commentContent;

    /**
     * 点赞数
     */
    @Column(name = "commnet_like")
    private Integer commnetLike;

    @Column(name = "crt_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date crtTime;

    /**
     * 用户名
     */
    private String uname;

    @Column(name = "imgUrl")
    private String imgurl;

    private String attr4;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return uid - 用户id
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置用户id
     *
     * @param uid 用户id
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取文章id
     *
     * @return artical_id - 文章id
     */
    public Integer getArticalId() {
        return articalId;
    }

    /**
     * 设置文章id
     *
     * @param articalId 文章id
     */
    public void setArticalId(Integer articalId) {
        this.articalId = articalId;
    }

    /**
     * 获取评论内容
     *
     * @return comment_content - 评论内容
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置评论内容
     *
     * @param commentContent 评论内容
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * 获取点赞数
     *
     * @return commnet_like - 点赞数
     */
    public Integer getCommnetLike() {
        return commnetLike;
    }

    /**
     * 设置点赞数
     *
     * @param commnetLike 点赞数
     */
    public void setCommnetLike(Integer commnetLike) {
        this.commnetLike = commnetLike;
    }

    /**
     * @return crt_time
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * @param crtTime
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * 获取用户名
     *
     * @return uname - 用户名
     */
    public String getUname() {
        return uname;
    }

    /**
     * 设置用户名
     *
     * @param uname 用户名
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * @return imgUrl
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * @param imgurl
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * @return attr4
     */
    public String getAttr4() {
        return attr4;
    }

    /**
     * @param attr4
     */
    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }
}