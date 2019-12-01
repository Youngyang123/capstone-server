package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Artical;
import cn.yg.capstoneserver.entity.vo.ArticalVo;
import cn.yg.capstoneserver.mapper.ArticalMapper;
import cn.yg.capstoneserver.mapper.CommentMapper;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ArticalBiz {
    @Autowired
    private ArticalMapper articalMapper;
    @Autowired
    private CommentMapper commentMapper;


    public QueryResponseResult<ArticalVo> getByTime() {
        Example example = new Example(Artical.class);
        example.orderBy("crtTime").desc();
        List<Artical> articals = articalMapper.selectByExample(example);
        return null;
    }
}
