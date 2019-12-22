package cn.yg.capstoneserver.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class Query extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private int pageNum = 1;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    private int pageSize = 10;

    public Query(Map<String, Object> params){
        this.putAll(params);

        if(params.get("pageNum")!=null) {
            this.pageNum = Integer.parseInt(params.get("pageNum").toString());
        }
        if(params.get("pageSize")!=null) {
            this.pageSize = Integer.parseInt(params.get("pageSize").toString());
        }
        this.remove("pageNum");
        this.remove("pageSize");
    }


}
