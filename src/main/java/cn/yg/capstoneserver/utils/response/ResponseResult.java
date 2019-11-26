package cn.yg.capstoneserver.utils.response;

public class ResponseResult {
    private int code = 20000;
    private String message;

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(String message){
        this.message = message;
    }

    public ResponseResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
