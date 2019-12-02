package cn.yg.capstoneserver.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class User {
    @Id
    private String id;
    private String name;
    private String passwd;
    private String photo;
    private Integer age;
    @Column(name = "school_id")
    private String schoolId;
    @Column(name = "academy_id")
    private String academyId;
    @Column(name = "major_id")
    private String majorId;
    @Column(name = "clazz_id")
    private String clazzId;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", photo='" + photo + '\'' +
                ", age=" + age +
                ", schoolId='" + schoolId + '\'' +
                ", academyId='" + academyId + '\'' +
                ", majorId='" + majorId + '\'' +
                ", clazzId='" + clazzId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }
}
