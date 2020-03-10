package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Setting;
import cn.yg.capstoneserver.mapper.SettingMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SettingBiz extends BaseBiz<SettingMapper, Setting> {
}
