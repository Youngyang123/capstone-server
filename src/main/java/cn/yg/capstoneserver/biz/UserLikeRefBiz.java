package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.UserLikeRef;
import cn.yg.capstoneserver.mapper.UserLikeRefMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLikeRefBiz extends BaseBiz<UserLikeRefMapper, UserLikeRef> {

    public ObjectResponseResult add(UserLikeRef userLikeRef) {
        List<UserLikeRef> select = mapper.select(userLikeRef);
        if (select.size() != 0) {
            return ObjectResponseResult.getInstance()
                    .code(40000)
                    .success(false);
        }
        mapper.insert(userLikeRef);
        return ObjectResponseResult.getInstance()
                .success(true);
    }
}
