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
    @Column(name = "comment_count")
    private Integer commentCount;

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

    /**
     * 分类id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    private String content;

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
     * @return comment_count - 评论数
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 设置评论数
     *
     * @param commentCount 评论数
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
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
     * 获取分类id
     *
     * @return category_id - 分类id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类id
     *
     * @param categoryId 分类id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取分类名称
     *
     * @return category_name - 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名称
     *
     * @param categoryName 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}