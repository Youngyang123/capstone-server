package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Clazz;
import cn.yg.capstoneserver.mapper.ClazzMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzBiz extends BaseBiz<ClazzMapper, Clazz> {

    @Autowired
    private SchoolBiz schoolBiz;
    @Autowired
    private AcademyBiz academyBiz;
    @Autowired
    private MajorBiz majorBiz;
    public ObjectResponseResult add(Clazz clazz) {
        Clazz clazzCheck = new Clazz();
        clazzCheck.setSchoolId(clazz.getSchoolId());
        clazzCheck.setAcademyId(clazz.getAcademyId());
        clazzCheck.setMajorId(clazz.getMajorId());
        clazzCheck.setName(clazz.getName());
        if (mapper.select(clazzCheck).size() > 0) {
            return new ObjectResponseResult()
                    .success(false)
                    .message("该班级已经存在");
        }
        clazz.setSchoolName(schoolBiz.selectById(clazz.getSchoolId()).getName());
        clazz.setAcademyName(academyBiz.selectById(clazz.getAcademyId()).getName());
        clazz.setMajorName(majorBiz.selectById(clazz.getMajorId()).getName());
        mapper.insert(clazz);
        return new ObjectResponseResult()
                .message("添加成功");
    }

    public QueryResponseResult getBySAMId(int schoolId, int academyId, int majorId) {
        Clazz clazz = new Clazz();
        clazz.setSchoolId(schoolId);
        clazz.setAcademyId(academyId);
        clazz.setMajorId(majorId);
        List<Clazz> select = mapper.select(clazz);
        return new QueryResponseResult(select, select.size());
    }
}
