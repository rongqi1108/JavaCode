package com.rong.exception;

import com.rong.constants.StatusCodeEnum;

/**
 * 自定义业务异常
 * @Author: RQ
 * @Date: 2023-02-17 10:39:37
 */
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = -5234400708L;

    private StatusCodeEnum statusInfo;

    public ServiceException(StatusCodeEnum statusInfo){
        super(statusInfo == null ? StatusCodeEnum.FAIL.getRemark() : statusInfo.getRemark());
        this.statusInfo = statusInfo == null ? StatusCodeEnum.FAIL : statusInfo;
    }

    public StatusCodeEnum getStatusInfo() {
        return statusInfo;
    }
}
