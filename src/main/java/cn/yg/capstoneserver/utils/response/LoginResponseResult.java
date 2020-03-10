package cn.yg.capstoneserver.utils.response;

import cn.yg.capstoneserver.utils.jwt.utils.Token;
import lombok.Data;

@Data
public class LoginResponseResult extends ResponseResult {
    private Token token;

    public LoginResponseResult(int code, String message, Token token) {
        super(code, message, true);
        this.token = token;
    }
    public LoginResponseResult(int code, String message, Token token, boolean success) {
        super(code, message, success);
        this.token = token;
    }

    public LoginResponseResult(String message, Token token) {
        super(message);
        this.token = token;
    }

}
