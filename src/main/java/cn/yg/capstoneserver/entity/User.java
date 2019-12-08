package cn.yg.capstoneserver.entity;

import javax.persistence.*;

public class User {
    /**
     * 学号
     */
    @Id
    private String id;

    /**
     * 书名
     */
    private String name;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 头像
     */
    private String photo;

    /**
     * 年龄
     */
    private Integer age;

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
     * 班级id
     */
    @Column(name = "clazz_id")
    private Integer clazzId;

    /**
     * 学校名称
     */
    @Column(name = "school_name")
    private String schoolName;

    /**
     * 学院名称
     */
    @Column(name = "academy_name")
    private String academyName;

    /**
     * 专业
     */
    @Column(name = "major_name")
    private String majorName;

    /**
     * 班级
     */
    @Column(name = "clazz_name")
    private String clazzName;

    /**
     * 获取学号
     *
     * @return id - 学号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置学号
     *
     * @param id 学号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取书名
     *
     * @return name - 书名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置书名
     *
     * @param name 书名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取密码
     *
     * @return passwd - 密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置密码
     *
     * @param passwd 密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * 获取头像
     *
     * @return photo - 头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置头像
     *
     * @param photo 头像
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
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
     * 获取班级id
     *
     * @return clazz_id - 班级id
     */
    public Integer getClazzId() {
        return clazzId;
    }

    /**
     * 设置班级id
     *
     * @param clazzId 班级id
     */
    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    /**
     * 获取学校名称
     *
     * @return school_name - 学校名称
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置学校名称
     *
     * @param schoolName 学校名称
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * 获取学院名称
     *
     * @return academy_name - 学院名称
     */
    public String getAcademyName() {
        return academyName;
    }

    /**
     * 设置学院名称
     *
     * @param academyName 学院名称
     */
    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    /**
     * 获取专业
     *
     * @return major_name - 专业
     */
    public String getMajorName() {
        return majorName;
    }

    /**
     * 设置专业
     *
     * @param majorName 专业
     */
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    /**
     * 获取班级
     *
     * @return clazz_name - 班级
     */
    public String getClazzName() {
        return clazzName;
    }

    /**
     * 设置班级
     *
     * @param clazzName 班级
     */
    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
}