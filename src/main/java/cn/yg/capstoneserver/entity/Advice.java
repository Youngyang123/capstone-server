package cn.yg.capstoneserver.entity;

import java.util.Date;
import javax.persistence.*;

public class Advice {
    @Id
    private Integer id;

    private String title;

    private String content;

    @Column(name = "crtTime")
    private Date crttime;

    @Column(name = "updTime")
    private Date updtime;

    private Integer status;

    @Column(name = "notice_order")
    private Integer noticeOrder;

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return crtTime
     */
    public Date getCrttime() {
        return crttime;
    }

    /**
     * @param crttime
     */
    public void setCrttime(Date crttime) {
        this.crttime = crttime;
    }

    /**
     * @return updTime
     */
    public Date getUpdtime() {
        return updtime;
    }

    /**
     * @param updtime
     */
    public void setUpdtime(Date updtime) {
        this.updtime = updtime;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return notice_order
     */
    public Integer getNoticeOrder() {
        return noticeOrder;
    }

    /**
     * @param noticeOrder
     */
    public void setNoticeOrder(Integer noticeOrder) {
        this.noticeOrder = noticeOrder;
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