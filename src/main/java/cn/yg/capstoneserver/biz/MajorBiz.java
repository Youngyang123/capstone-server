package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Major;
import cn.yg.capstoneserver.mapper.MajorMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class MajorBiz extends BaseBiz<MajorMapper, Major> {
    @Autowired
    private SchoolBiz schoolBiz;
    @Autowired
    private AcademyBiz academyBiz;
    public ObjectResponseResult add(Major major) {
        Example example = new Example(Major.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("schoolId", major.getSchoolId());
        criteria.andEqualTo("academyId", major.getAcademyId());
        criteria.andEqualTo("name", major.getName());
        if (mapper.selectByExample(example).size() > 0) {
            return new ObjectResponseResult<Major>()
                    .success(false)
                    .message("该学院下已经有这个专业了");
        }
        major.setSchoolName(schoolBiz.selectById(major.getSchoolId()).getName());
        major.setAcademyName(academyBiz.selectById(major.getAcademyId()).getName());
        mapper.insert(major);
        return new ObjectResponseResult().message("添加成功");
    }

    public QueryResponseResult getBySidAndAid(int schoolId, int academyId) {
        Major major = new Major();
        major.setSchoolId(schoolId);
        major.setAcademyId(academyId);
        List<Major> majors = mapper.select(major);
        return new QueryResponseResult(majors, majors.size());
    }
}
