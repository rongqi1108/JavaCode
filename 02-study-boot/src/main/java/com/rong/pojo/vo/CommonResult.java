package com.rong.pojo.vo;

import com.rong.constants.StatusCodeEnum;

import java.io.Serializable;

/**
 * @Author: RQ
 * @Date: 2023-02-17 09:05:19
 */
public class CommonResult<T> implements Serializable {
    private String status;
    private String remark;
    private T data;

    public CommonResult() {
    }

    public CommonResult(StatusCodeEnum statusCodeEnum, T data) {
        this.data = data;
        this.status = statusCodeEnum.getStatusCode();
        this.remark = statusCodeEnum.getRemark();
    }

    public static <T> CommonResult<T> success(T data){
        return new CommonResult<>(StatusCodeEnum.SUCCESS, data);
    }

    public static <T> CommonResult<T> fail(T data){
        return new CommonResult<>(StatusCodeEnum.FAIL, data);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
