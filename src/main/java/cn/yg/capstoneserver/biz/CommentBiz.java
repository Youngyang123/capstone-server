package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Artical;
import cn.yg.capstoneserver.entity.Comment;
import cn.yg.capstoneserver.entity.User;
import cn.yg.capstoneserver.mapper.CommentMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentBiz extends BaseBiz<CommentMapper, Comment> {

    @Autowired
    private UserBiz userBiz;

    @Autowired
    private ArticalBiz articalBiz;
    public ObjectResponseResult add(Comment comment) {
        User user = userBiz.selectById(comment.getUid());
        Artical artical = articalBiz.selectById(comment.getArticalId());
        if (user == null || artical == null) {
            return ObjectResponseResult.getInstance()
                    .success(false)
                    .message("用户或文章不存在")
                    .code(40000);
        }
        artical.setCommentCount(artical.getCommentCount() + 1);
        comment.setImgurl(user.getPhoto());
        comment.setUname(user.getName());
        comment.setCrtTime(new Date());
        comment.setCommnetLike(0);
        mapper.insertSelective(comment);
        articalBiz.updateById(artical);
        return ObjectResponseResult.getInstance();
    }
}
