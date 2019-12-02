package cn.yg.capstoneserver.entity.vo;

import cn.yg.capstoneserver.entity.User;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserVo extends User {
    private String schoolName;
    private String academyName;
    private String majorName;
    private String clazzName;
}
