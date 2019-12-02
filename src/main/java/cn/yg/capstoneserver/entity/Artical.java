package cn.yg.capstoneserver.entity;

import java.util.Date;
import javax.persistence.*;

public class Artical {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 点赞数
     */
    private Integer like;

    /**
     * 评论数
     */
    @Column(name = "comment_id")
    private Integer commentId;

    /**
     * 图片
     */
    @Column(name = "imgUrl")
    private String imgurl;

    /**
     * 创建时间
     */
    @Column(name = "crt_time")
    private Date crtTime;

    private String attr2;

    private String attr3;

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
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取点赞数
     *
     * @return like - 点赞数
     */
    public Integer getLike() {
        return like;
    }

    /**
     * 设置点赞数
     *
     * @param like 点赞数
     */
    public void setLike(Integer like) {
        this.like = like;
    }

    /**
     * 获取评论数
     *
     * @return comment_id - 评论数
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 设置评论数
     *
     * @param commentId 评论数
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取图片
     *
     * @return imgUrl - 图片
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * 设置图片
     *
     * @param imgurl 图片
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * 获取创建时间
     *
     * @return crt_time - 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * 设置创建时间
     *
     * @param crtTime 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * @return attr2
     */
    public String getAttr2() {
        return attr2;
    }

    /**
     * @param attr2
     */
    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    /**
     * @return attr3
     */
    public String getAttr3() {
        return attr3;
    }

    /**
     * @param attr3
     */
    public void setAttr3(String attr3) {
        this.attr3 = attr3;
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