package com.project.commonutils;

/**
 * @Author: zsp
 * @Description: 统一结果返回类枚举
 * @Date: Create in 19:05 2020/4/29
 */
public enum ResultCode {
    // 成功
    SUCCESS(200),
    // 失败
    FAIL(201);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
