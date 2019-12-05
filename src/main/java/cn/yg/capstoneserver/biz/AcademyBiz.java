package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Academy;
import cn.yg.capstoneserver.entity.School;
import cn.yg.capstoneserver.mapper.AcademyMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AcademyBiz extends BaseBiz<AcademyMapper, Academy> {

    @Autowired
    private SchoolBiz schoolBiz;

    public ObjectResponseResult add(Academy academy) {
        School school = schoolBiz.selectById(academy.getSchoolId());
        if(school == null) {
            return new ObjectResponseResult().success(false);
        }
        academy.setSchoolName(school.getName());
        mapper.insert(academy);
        return new ObjectResponseResult();
    }
}
