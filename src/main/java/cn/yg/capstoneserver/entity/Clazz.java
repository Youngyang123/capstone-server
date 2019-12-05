package cn.yg.capstoneserver.entity;

import java.util.Date;
import javax.persistence.*;

public class Clazz {
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
     * 专业id
     */
    @Column(name = "major_id")
    private Integer majorId;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 班主任
     */
    @Column(name = "clazz_teacher")
    private String clazzTeacher;

    /**
     * 班长
     */
    private String monitor;

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

    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "academy_name")
    private String academyName;
    @Column(name = "major_name")
    private String majorName;

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
     * 获取专业id
     *
     * @return major_id - 专业id
     */
    public Integer getMajorId() {
        return majorId;
    }

    /**
     * 设置专业id
     *
     * @param majorId 专业id
     */
    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    /**
     * 获取班级名称
     *
     * @return name - 班级名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置班级名称
     *
     * @param name 班级名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取班主任
     *
     * @return clazz_teacher - 班主任
     */
    public String getClazzTeacher() {
        return clazzTeacher;
    }

    /**
     * 设置班主任
     *
     * @param clazzTeacher 班主任
     */
    public void setClazzTeacher(String clazzTeacher) {
        this.clazzTeacher = clazzTeacher;
    }

    /**
     * 获取班长
     *
     * @return monitor - 班长
     */
    public String getMonitor() {
        return monitor;
    }

    /**
     * 设置班长
     *
     * @param monitor 班长
     */
    public void setMonitor(String monitor) {
        this.monitor = monitor;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
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