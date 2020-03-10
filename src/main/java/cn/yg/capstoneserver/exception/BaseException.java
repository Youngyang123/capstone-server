package cn.yg.capstoneserver.exception;

public interface BaseException  {
    /**
     * 异常信息
     */
    String getMessage();

    /**
     * 具体异常码
     */
    int getCode();



}
