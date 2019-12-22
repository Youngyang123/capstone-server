package cn.yg.capstoneserver.controller;

import cn.yg.capstoneserver.biz.SettingBiz;
import cn.yg.capstoneserver.entity.Setting;
import cn.yg.capstoneserver.utils.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("setting")
public class SettingController extends BaseController<SettingBiz, Setting> {
}
