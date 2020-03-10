package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.ImportUser;
import cn.yg.capstoneserver.mapper.ImportUserMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ImportUserBiz extends BaseBiz<ImportUserMapper, ImportUser> {
}
