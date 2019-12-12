package cn.yg.capstoneserver.entity.vo;

import cn.yg.capstoneserver.entity.Category;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryVo extends Category {
    private List<CategoryVo> children = new ArrayList<>();
}
