package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.SchoolBiz;
import cn.yg.capstoneserver.entity.School;
import cn.yg.capstoneserver.utils.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("school")
public class SchoolController extends BaseController<SchoolBiz, School> {


}
