package com.test.code;

public enum ResultEnum {
    /** 密码错误 */
    LOGIN_PASSWORD_ERROR(401,"密码错误"),
    /** 登录成功 */
    LOGIN_SUCCESS(200,"登录成功"),
    ;

    /** 状态码 */
    private Integer code;
    /** 信息 */
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
