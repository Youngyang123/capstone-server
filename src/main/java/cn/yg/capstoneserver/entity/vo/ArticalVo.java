package cn.yg.capstoneserver.entity.vo;


import cn.yg.capstoneserver.entity.Artical;
import cn.yg.capstoneserver.entity.ArticalContent;
import cn.yg.capstoneserver.entity.Comment;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class ArticalVo extends Artical {
    private List<Comment> comments;
    private Integer numberOfComment;
    private ArticalContent articalContent;

}
