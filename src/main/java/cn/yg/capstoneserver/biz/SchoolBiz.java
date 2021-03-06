package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.School;
import cn.yg.capstoneserver.mapper.SchoolMapper;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SchoolBiz extends BaseBiz<SchoolMapper, School> {

    public ObjectResponseResult<School> add(School school) {
        Example example = new Example(School.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", school.getName());
        List<School> schools = mapper.selectByExample(example);
        if (schools.size() > 0) {
            return new ObjectResponseResult<>()
                    .success(false)
                    .message("学校已存在");
        }
        school.setCrtTime(new Date());
        mapper.insert(school);
        return new ObjectResponseResult<>().message("添加成功");
    }
}
