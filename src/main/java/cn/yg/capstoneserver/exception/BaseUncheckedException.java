package cn.yg.capstoneserver.exception;

import cn.yg.capstoneserver.exception.code.ExceptionCode;

public class BaseUncheckedException extends RuntimeException implements BaseException {

    protected String message;
    protected Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getCode() {
        return code;
    }

    public BaseUncheckedException(int code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public BaseUncheckedException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.message = exceptionCode.getMessage();
        this.code = exceptionCode.getCode();
    }
}
