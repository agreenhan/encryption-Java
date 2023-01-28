package com.example.encryptionjava.common.constant;

/**
 * @Description: http状态码
 * @Author: jht
 * @DATE: 2023/1/27 15:05
 */
public enum HttpStates {
    SUCCESS(20000, "操作成功"),
    FAILED(20001, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或session已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    UNKNOWN(99999, "未知异常，请稍后再试！");

    private final Integer code;
    private final String message;

    HttpStates(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
