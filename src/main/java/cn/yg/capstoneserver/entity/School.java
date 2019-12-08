package cn.yg.capstoneserver.entity;

import java.util.Date;
import javax.persistence.*;

public class School {
    @Id
    private Integer id;

    /**
     * 学校名称
     */
    private String name;

    /**
     * 校长
     */
    private String owner;

    /**
     * 创建时间
     */
    @Column(name = "crt_time")
    private Date crtTime;

    /**
     * 更新时间
     */
    @Column(name = "upd_time")
    private Date updTime;

    /**
     * 学校成立时间
     */
    @Column(name = "build_time")
    private Date buildTime;

    /**
     * 学校描述
     */
    @Column(name = "school_desc")
    private String schoolDesc;

    /**
     * 官网
     */
    private String website;

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
     * 获取学校名称
     *
     * @return name - 学校名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学校名称
     *
     * @param name 学校名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取校长
     *
     * @return owner - 校长
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 设置校长
     *
     * @param owner 校长
     */
    public void setOwner(String owner) {
        this.owner = owner;
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
     * 获取更新时间
     *
     * @return upd_time - 更新时间
     */
    public Date getUpdTime() {
        return updTime;
    }

    /**
     * 设置更新时间
     *
     * @param updTime 更新时间
     */
    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    /**
     * 获取学校成立时间
     *
     * @return build_time - 学校成立时间
     */
    public Date getBuildTime() {
        return buildTime;
    }

    /**
     * 设置学校成立时间
     *
     * @param buildTime 学校成立时间
     */
    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    /**
     * 获取学校描述
     *
     * @return school_desc - 学校描述
     */
    public String getSchoolDesc() {
        return schoolDesc;
    }

    /**
     * 设置学校描述
     *
     * @param schoolDesc 学校描述
     */
    public void setSchoolDesc(String schoolDesc) {
        this.schoolDesc = schoolDesc;
    }

    /**
     * 获取官网
     *
     * @return website - 官网
     */
    public String getWebsite() {
        return website;
    }

    /**
     * 设置官网
     *
     * @param website 官网
     */
    public void setWebsite(String website) {
        this.website = website;
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