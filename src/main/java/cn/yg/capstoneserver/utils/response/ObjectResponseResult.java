package cn.yg.capstoneserver.utils.response;

public class ObjectResponseResult<T> extends ResponseResult {
    private T data;

    public ObjectResponseResult(int code, String message, T data) {
        super(code, message);
        this.data = data;
    }

    public ObjectResponseResult() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
