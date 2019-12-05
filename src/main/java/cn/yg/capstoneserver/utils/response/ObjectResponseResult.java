package cn.yg.capstoneserver.utils.response;

public class ObjectResponseResult<T> extends ResponseResult {
    private T data;

    public ObjectResponseResult(int code, String message, T data) {
        super(code, message, true);
        this.data = data;
    }

    public ObjectResponseResult(int code, String message, T data, boolean success) {
        super(code, message, success);
        this.data = data;
    }

    public ObjectResponseResult() {
    }

    public ObjectResponseResult data(T data) {
        this.setData(data);
        return this;
    }

    public ObjectResponseResult message(String message) {
        super.setMessage(message);
        return this;
    }

    public ObjectResponseResult success(boolean success) {
        super.setSuccess(success);
        return this;
    }

    public ObjectResponseResult code(int code) {
        super.setCode(code);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
