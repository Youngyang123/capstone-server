package cn.yg.capstoneserver.utils.jwt.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtInfo implements Serializable {

    private String userId;
    private String name;
}
