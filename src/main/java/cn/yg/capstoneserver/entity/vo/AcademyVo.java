package cn.yg.capstoneserver.entity.vo;

import cn.yg.capstoneserver.entity.Academy;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AcademyVo extends Academy {
    private String schoolName;
}
