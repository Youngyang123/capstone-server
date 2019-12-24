package cn.yg.capstoneserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_focus")
public class UserFocus {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 被关注用户id
     */
    private String fid;

    /**
     * 创建时间
     */
    @Column(name = "crt_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
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
     * 获取被关注用户id
     *
     * @return fid - 被关注用户id
     */
    public String getFid() {
        return fid;
    }

    /**
     * 设置被关注用户id
     *
     * @param fid 被关注用户id
     */
    public void setFid(String fid) {
        this.fid = fid;
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
}