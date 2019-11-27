package cn.yg.capstoneserver.entity.vo;


import cn.yg.capstoneserver.entity.Artical;
import cn.yg.capstoneserver.entity.ArticalContent;
import cn.yg.capstoneserver.entity.Comment;

import java.util.List;

public class ArticalVo extends Artical {
    private List<Comment> comments;
    private Integer numberOfComment;
    private ArticalContent articalContent;

    public ArticalContent getArticalContent() {
        return articalContent;
    }

    public void setArticalContent(ArticalContent articalContent) {
        this.articalContent = articalContent;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getNumberOfComment() {
        return numberOfComment;
    }

    public void setNumberOfComment(Integer numberOfComment) {
        this.numberOfComment = numberOfComment;
    }
}
