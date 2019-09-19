package com.test.code;

public enum ResultEnum {
    /** 密码错误 */
    LOGIN_PASSWORD_ERROR(401,"用户名或密码错误"),
    /** 登录成功 */
    LOGIN_SUCCESS(200,"登录成功"),
    /** 用户名或密码为空 */
    USERNAME_PASSWORD_EMPTY(402,"用户名或密码不能为空"),
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
