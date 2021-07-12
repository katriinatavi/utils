package org.songtang.enums;

/**
 * 自定义响应状态码
 *
 * @author: song
 * @Date: Created in 2021/07/12  14:02
 * @Modified By:
 */
public enum SelfHttpStatus {
    PARAMS_IS_NULL(10001,"Parameter is null"),
    PARAMS_NOT_COMPLETE(10004,"Parameter is invalid")
    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    SelfHttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
