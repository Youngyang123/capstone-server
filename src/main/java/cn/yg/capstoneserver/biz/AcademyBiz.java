package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Academy;
import cn.yg.capstoneserver.entity.School;
import cn.yg.capstoneserver.mapper.AcademyMapper;
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
public class AcademyBiz extends BaseBiz<AcademyMapper, Academy> {

    @Autowired
    private SchoolBiz schoolBiz;

    /**
     * 添加学院
     * @param academy
     * @return
     */
    public ObjectResponseResult add(Academy academy) {
        Academy academyCheck = new Academy();
        academyCheck.setSchoolId(academy.getSchoolId());
        academyCheck.setName(academy.getName());
        if (mapper.select(academyCheck).size() > 0) {
            return new ObjectResponseResult()
                    .success(false)
                    .message("该学校已经存在这个学院");
        }
        School school = schoolBiz.selectById(academy.getSchoolId());
        academy.setSchoolName(school.getName());
        mapper.insert(academy);
        return new ObjectResponseResult();
    }

    /**
     * 查询学校下的所有学院
     * @param schoolId
     * @return
     */
    public QueryResponseResult<Academy> getBySchoolId(int schoolId) {
        Example example = new Example(Academy.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("schoolId", schoolId);
        List<Academy> academies = mapper.selectByExample(example);
        return new QueryResponseResult<>(academies, academies.size());
    }
}
