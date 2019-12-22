package cn.yg.capstoneserver.entity;

import javax.persistence.*;

public class Setting {
    @Id
    private Integer id;

    /**
     * 文章显示字数
     */
    @Column(name = "word_num")
    private Integer wordNum;

    /**
     * 超出字数后显示
     */
    @Column(name = "word_exceed")
    private String wordExceed;

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
     * 获取文章显示字数
     *
     * @return word_num - 文章显示字数
     */
    public Integer getWordNum() {
        return wordNum;
    }

    /**
     * 设置文章显示字数
     *
     * @param wordNum 文章显示字数
     */
    public void setWordNum(Integer wordNum) {
        this.wordNum = wordNum;
    }

    /**
     * 获取超出字数后显示
     *
     * @return word_exceed - 超出字数后显示
     */
    public String getWordExceed() {
        return wordExceed;
    }

    /**
     * 设置超出字数后显示
     *
     * @param wordExceed 超出字数后显示
     */
    public void setWordExceed(String wordExceed) {
        this.wordExceed = wordExceed;
    }
}