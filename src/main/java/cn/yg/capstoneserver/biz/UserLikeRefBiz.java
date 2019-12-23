package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Artical;
import cn.yg.capstoneserver.entity.UserLikeRef;
import cn.yg.capstoneserver.mapper.UserLikeRefMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserLikeRefBiz extends BaseBiz<UserLikeRefMapper, UserLikeRef> {

    @Autowired
    private ArticalBiz articalBiz;

    public ObjectResponseResult toggle(UserLikeRef userLikeRef) {
        Artical artical = articalBiz.selectById(userLikeRef.getAid());
        if (artical == null ) {
            return ObjectResponseResult.getInstance()
                    .code(40000)
                    .success(false);
        }
        List<UserLikeRef> select = mapper.select(userLikeRef);
        if (select.size() != 0) {
            // 存在就删除
            mapper.delete(userLikeRef);
            artical.setArticalLike(artical.getArticalLike() - 1);
            articalBiz.updateById(artical);
            return ObjectResponseResult.getInstance()
                    .message("取消点赞成功");
        }
        userLikeRef.setCrtTime(new Date());
        mapper.insert(userLikeRef);
        artical.setArticalLike(artical.getArticalLike() + 1);
        articalBiz.updateById(artical);
        return ObjectResponseResult.getInstance()
                .message("点赞成功");
    }
}
