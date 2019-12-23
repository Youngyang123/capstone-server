package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Artical;
import cn.yg.capstoneserver.entity.UserCollection;
import cn.yg.capstoneserver.mapper.UserCollectionMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserCollectionBiz extends BaseBiz<UserCollectionMapper, UserCollection> {
    @Autowired
    private ArticalBiz articalBiz;
    public ObjectResponseResult toggle(UserCollection userCollection) {
        Artical artical = articalBiz.selectById(userCollection.getAid());
        if (artical == null) {
            return ObjectResponseResult.getInstance()
                    .success(false)
                    .message("文章不存在")
                    .code(40000);
        }

        List<UserCollection> select = mapper.select(userCollection);
        if (select.size() != 0) {
            mapper.delete(userCollection);
            return ObjectResponseResult.getInstance()
                    .message("取消收藏成功");
        }

        userCollection.setCrtTime(new Date());
        mapper.insertSelective(userCollection);
        return ObjectResponseResult.getInstance()
                .message("收藏成功");
    }
}
