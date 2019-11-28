package cn.yg.capstoneserver.utils.response;

public class LoginResponseResult extends ResponseResult {
    private String uid;

    public LoginResponseResult(int code, String message, String uid) {
        super(code, message);
        this.uid = uid;
    }

    public LoginResponseResult(String message, String uid) {
        super(message);
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}