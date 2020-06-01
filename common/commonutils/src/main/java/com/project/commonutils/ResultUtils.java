package com.project.commonutils;

/**
 * @Author: zsp
 * @Description:
 * @Date: Create in 19:17 2020/4/29
 */
public class ResultUtils {

    private final static String SUCCESS = "success";
    private final static String FAIL = "fail";

    public static <T> Result<T> genSuccessForResult() {
        return new Result<T>()
                .setStatus(true)
                .setCode(ResultCode.SUCCESS)
                .setMsg(SUCCESS);
    }

    public static <T> Result<T> genSuccessForResult(T data) {
        return new Result<T>()
                .setStatus(true)
                .setCode(ResultCode.SUCCESS)
                .setMsg(SUCCESS)
                .setData(data);
    }

    public static <T> Result<T> genFailForResult(String message) {
        return new Result<T>()
                .setStatus(false)
                .setCode(ResultCode.FAIL)
                .setMsg(message);
    }

    public static <T> Result<T> genResult(int code, String msg) {
        return new Result<T>().setCode(code).setMsg(msg);
    }

    public static <T> Result<T> genResult(int code, String msg, T data) {
        return new Result<T>().setCode(code).setMsg(msg).setData(data);
    }
}
