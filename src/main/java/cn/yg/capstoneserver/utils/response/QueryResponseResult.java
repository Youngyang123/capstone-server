package cn.yg.capstoneserver.utils.response;

import java.util.List;

public class QueryResponseResult<T> extends ResponseResult {
    private List<T> data;
    private long total;

    public QueryResponseResult(int code, String message, List<T> data, long total) {
        super(code, message);
        this.data = data;
        this.total = total;
    }

    public QueryResponseResult(String message, List<T> data, long total) {
        super(message);
        this.data = data;
        this.total = total;
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
