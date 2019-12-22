package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.CommentBiz;
import cn.yg.capstoneserver.entity.Comment;
import cn.yg.capstoneserver.utils.controller.BaseController;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
@CrossOrigin
public class CommentController extends BaseController<CommentBiz, Comment> {

    @PostMapping
    @Override
    public ObjectResponseResult add(@RequestBody Comment comment) {
        return baseBiz.add(comment);
    }
}
