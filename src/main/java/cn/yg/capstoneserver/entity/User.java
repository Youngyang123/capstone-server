package cn.yg.capstoneserver.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Data
@ToString
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

}
