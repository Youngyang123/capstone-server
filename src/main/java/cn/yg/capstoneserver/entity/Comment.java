package cn.yg.capstoneserver.entity;

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

    @Column(name = "crtTime")
    private Date crttime;

    /**
     * 用户名
     */
    private String uname;

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
     * @return crtTime
     */
    public Date getCrttime() {
        return crttime;
    }

    /**
     * @param crttime
     */
    public void setCrttime(Date crttime) {
        this.crttime = crttime;
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