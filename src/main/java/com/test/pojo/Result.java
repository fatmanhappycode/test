package com.test.pojo;

import com.test.code.ResultEnum;

/**
 * @author 肥宅快乐码
 * @date 2018/10/11 - 22:27
 * 存放返回的结果信息，包括状态码等
 */
public class Result<T> {
    /**
     * 返回状态码
     */
    private int code;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 返回提示信息
     */
    private String msg;

    public Result() {
        super();
    }

    public Result(int code, T data, String msg) {

        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result<T> setResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public Result<T> setResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Result<T> setResult(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        return this;
    }
    @Override
    public String toString() {
        return "Result [code=" + code + ", data=" + data + ", msg=" + msg + "]";
    }
}

