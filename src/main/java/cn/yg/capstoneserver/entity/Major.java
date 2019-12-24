package cn.yg.capstoneserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

public class Major {
    @Id
    private Integer id;

    /**
     * 学校id
     */
    @Column(name = "school_id")
    private Integer schoolId;

    /**
     * 学院id
     */
    @Column(name = "academy_id")
    private Integer academyId;

    /**
     * 专业名称
     */
    private String name;

    /**
     * 专业负责人
     */
    @Column(name = "major_teacher")
    private String majorTeacher;

    /**
     * 创建时间
     */
    @Column(name = "crt_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date crtTime;

    /**
     * 更新时间
     */
    @Column(name = "upd_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updTime;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "academy_name")
    private String academyName;

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
     * 获取学校id
     *
     * @return school_id - 学校id
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * 设置学校id
     *
     * @param schoolId 学校id
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取学院id
     *
     * @return academy_id - 学院id
     */
    public Integer getAcademyId() {
        return academyId;
    }

    /**
     * 设置学院id
     *
     * @param academyId 学院id
     */
    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    /**
     * 获取专业名称
     *
     * @return name - 专业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置专业名称
     *
     * @param name 专业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取专业负责人
     *
     * @return major_teacher - 专业负责人
     */
    public String getMajorTeacher() {
        return majorTeacher;
    }

    /**
     * 设置专业负责人
     *
     * @param majorTeacher 专业负责人
     */
    public void setMajorTeacher(String majorTeacher) {
        this.majorTeacher = majorTeacher;
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
     * @return school_name
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * @param schoolName
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * @return academy_name
     */
    public String getAcademyName() {
        return academyName;
    }

    /**
     * @param academyName
     */
    public void setAcademyName(String academyName) {
        this.academyName = academyName;
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