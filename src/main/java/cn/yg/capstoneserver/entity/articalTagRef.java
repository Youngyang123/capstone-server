package cn.yg.capstoneserver.entity;

import javax.persistence.*;

@Table(name = "artical_tag_ref")
public class ArticalTagRef {
    @Id
    @Column(name = "artical_id")
    private Integer articalId;

    @Id
    @Column(name = "tag_id")
    private Integer tagId;

    /**
     * @return artical_id
     */
    public Integer getArticalId() {
        return articalId;
    }

    /**
     * @param articalId
     */
    public void setArticalId(Integer articalId) {
        this.articalId = articalId;
    }

    /**
     * @return tag_id
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * @param tagId
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}