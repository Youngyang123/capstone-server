package cn.yg.capstoneserver.entity;

import javax.persistence.*;

@Table(name = "artical_content")
public class ArticalContent {
    @Id
    private Integer id;

    /**
     * 文章id
     */
    @Column(name = "artical_id")
    private Integer articalId;

    /**
     * 文章内容
     */
    private String content;

    private String attr1;

    private String attr2;

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
     * 获取文章id
     *
     * @return artical_id - 文章id
     */
    public Integer getArticalId() {
        return articalId;
    }

    /**
     * 设置文章id
     *
     * @param articalId 文章id
     */
    public void setArticalId(Integer articalId) {
        this.articalId = articalId;
    }

    /**
     * 获取文章内容
     *
     * @return content - 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文章内容
     *
     * @param content 文章内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return attr1
     */
    public String getAttr1() {
        return attr1;
    }

    /**
     * @param attr1
     */
    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    /**
     * @return attr2
     */
    public String getAttr2() {
        return attr2;
    }

    /**
     * @param attr2
     */
    public void setAttr2(String attr2) {
        this.attr2 = attr2;
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