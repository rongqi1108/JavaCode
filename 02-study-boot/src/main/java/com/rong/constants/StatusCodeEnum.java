package com.rong.constants;

/**
 * 状态码 一般是类型+系统+模块+自定义（自行约定）
 * @Author: RQ
 * @Date: 2023-02-17 09:06:46
 */
public enum StatusCodeEnum {
    SUCCESS("000000","通用成功"),
    SYS_ERROR("010001", "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR("010101", "参数异常"),
    FAIL("100000","通用失败");
    private String statusCode;
    private String remark;

    StatusCodeEnum() {
    }

    StatusCodeEnum(String statusCode, String remark) {
        this.statusCode = statusCode;
        this.remark = remark;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getRemark() {
        return remark;
    }
}
