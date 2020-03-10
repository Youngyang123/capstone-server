package cn.yg.capstoneserver.exception.code;

public enum ExceptionCode implements BaseExceptionCode {
    JWT_TOKEN_EXPIRED(40001, "会话超时，请重新登录"),
    JWT_SIGNATURE(40002, "不合法的token，请认真比对 token 的签名"),
    JWT_ILLEGAL_ARGUMENT(40003, "缺少token参数"),
    JWT_GEN_TOKEN_FAIL(40004, "生成token失败"),
    JWT_PARSER_TOKEN_FAIL(40005, "解析token失败"),
    JWT_USER_INVALID(40006, "用户名或密码错误"),
    JWT_USER_ENABLED(40007, "用户已经被禁用！"),

    ;

    private int code;
    private String message;

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
