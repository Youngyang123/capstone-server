package cn.yg.capstoneserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import java.util.Date;
import javax.persistence.*;

@Table(name = "import_user")
public class ImportUser {
    @Id
    @KeySql(dialect = IdentityDialect.MYSQL)
    private Integer id;

    /**
     * 文件名前半部分
     */
    @Column(name = "file_head")
    private String fileHead;

    /**
     * 文件名后半部分
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 创建时间
     */
    @Column(name = "crt_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date crtTime;

    /**
     * 文件状态
     */
    private Integer status;

    /**
     * 文件服务器的url
     */
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 备注
     */
    private String remark;

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
     * 获取文件名前半部分
     *
     * @return file_head - 文件名前半部分
     */
    public String getFileHead() {
        return fileHead;
    }

    /**
     * 设置文件名前半部分
     *
     * @param fileHead 文件名前半部分
     */
    public void setFileHead(String fileHead) {
        this.fileHead = fileHead;
    }

    /**
     * 获取文件名后半部分
     *
     * @return file_name - 文件名后半部分
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名后半部分
     *
     * @param fileName 文件名后半部分
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取创建时间
     *
     * @return crt_time - 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * 设置创建时间
     *
     * @param crtTime 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * 获取文件状态
     *
     * @return status - 文件状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置文件状态
     *
     * @param status 文件状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取文件服务器的url
     *
     * @return file_url - 文件服务器的url
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 设置文件服务器的url
     *
     * @param fileUrl 文件服务器的url
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}