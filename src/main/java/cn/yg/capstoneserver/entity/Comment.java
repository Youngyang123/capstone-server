package cn.yg.capstoneserver.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "comment")
@Data
@ToString
public class Comment {
    @Id
    private Integer id;
    private String uid;
    @Column(name = "artical_id")
    private Integer articalId;
    @Column(name = "comment_content")
    private String commentContent;
    @Column(name = "comment_like")
    private Integer commentLike;
    private String attr1;
    private String attr2;
    private String attr3;
    private String attr4;
}
