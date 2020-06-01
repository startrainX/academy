package com.project.commonutils;

/**
 * @Author: zsp
 * @Description:
 * @Date: Create in 19:14 2020/4/29
 */
public class Result<T> {

    private boolean status;

    public int code;

    private String msg;

    private T data;

    public Result<T> setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public boolean getStatus() {
        return status;
    }

    public Result<T> setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
