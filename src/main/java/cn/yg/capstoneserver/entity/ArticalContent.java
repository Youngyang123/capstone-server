package cn.yg.capstoneserver.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "artical_content")
@Data
@ToString
public class ArticalContent {
    @Id
    private Integer id;
    @Column(name = "artical_id")
    private Integer articalId;
    private String content;
    private String attr1;
    private String attr2;
    private String attr3;
    private String attr4;
}
