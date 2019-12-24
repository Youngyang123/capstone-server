package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.ImportUserBiz;
import cn.yg.capstoneserver.entity.ImportUser;
import cn.yg.capstoneserver.utils.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("import")
public class ImportUserController extends BaseController<ImportUserBiz, ImportUser> {
}
