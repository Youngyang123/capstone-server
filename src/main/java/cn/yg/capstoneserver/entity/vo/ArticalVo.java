package cn.yg.capstoneserver.entity.vo;

import cn.yg.capstoneserver.entity.Artical;
import lombok.Data;

@Data
public class ArticalVo extends Artical {
    private Boolean isCollected;
    private Boolean isLike;
    private Boolean isFocus;
}
