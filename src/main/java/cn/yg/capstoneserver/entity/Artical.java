package cn.yg.capstoneserver.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "artical")
@Data
@ToString
public class Artical {
    @Id
    private Integer id;
    private Integer uid;
    private String title;
    private Integer like;
    @Column(name = "comment_id")
    private Integer commentId;
    private String imgUrl;
    @Column(name = "crt_time")
    private Date crtTime;
    private String attr2;
    private String attr3;
    private String attr4;

}
