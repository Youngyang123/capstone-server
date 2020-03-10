package cn.yg.capstoneserver.utils.jwt.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Token {

    private String token;

    private Integer expire;
}
