package cn.yg.capstoneserver.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_like_ref")
public class UserLikeRef {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 文章id
     */
    private String aid;

    /**
     * 点赞时间
     */
    @Column(name = "crt_time")
    private Date crtTime;

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
     * @return aid - 文章id
     */
    public String getAid() {
        return aid;
    }

    /**
     * 设置文章id
     *
     * @param aid 文章id
     */
    public void setAid(String aid) {
        this.aid = aid;
    }

    /**
     * 获取点赞时间
     *
     * @return crt_time - 点赞时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * 设置点赞时间
     *
     * @param crtTime 点赞时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}