package cn.yg.capstoneserver.utils.response;


public class SysLoginResponseResult extends ResponseResult {
    private String token;

    public SysLoginResponseResult(int code, String message, String token) {
        super(code, message);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
