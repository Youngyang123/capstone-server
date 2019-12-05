package cn.yg.capstoneserver.utils.response;

import java.util.List;

public class QueryResponseResult<T> extends ResponseResult {
    private List<T> data;
    private long total;

    public QueryResponseResult(int code, String message, List<T> data, long total, boolean success) {
        super(code, message, success);
        this.data = data;
        this.total = total;
    }

    public QueryResponseResult(int code, String message, List<T> data, long total) {
        super(code, message, true);
        this.data = data;
        this.total = total;
    }

    public QueryResponseResult(String message, List<T> data, long total) {
        super(message);
        this.data = data;
        this.total = total;
    }

    public QueryResponseResult data(List<T> data) {
        this.setData(data);
        return this;
    }

    public QueryResponseResult total(long total) {
        this.setTotal(total);
        return this;
    }

    public QueryResponseResult message(String message) {
        this.setMessage(message);
        return this;
    }

    public QueryResponseResult(List<T> data, long total){
        this("", data, total);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
