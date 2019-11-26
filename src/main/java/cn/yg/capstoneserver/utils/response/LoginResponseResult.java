package cn.yg.capstoneserver.utils.response;

public class LoginResponseResult extends ResponseResult {
    private Integer uid;

    public LoginResponseResult(int code, String message, Integer uid) {
        super(code, message);
        this.uid = uid;
    }

    public LoginResponseResult(String message, Integer uid) {
        super(message);
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
