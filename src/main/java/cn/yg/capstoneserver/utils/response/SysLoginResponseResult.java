package cn.yg.capstoneserver.utils.response;


import cn.yg.capstoneserver.utils.jwt.utils.Token;

public class SysLoginResponseResult extends ResponseResult {
    private String token;

    public SysLoginResponseResult(int code, String message, String token) {
        super(code, message, true);
        this.token = token;
    }

    public SysLoginResponseResult(int code, String message, String token, boolean success) {
        super(code, message, success);
        this.token = token;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
