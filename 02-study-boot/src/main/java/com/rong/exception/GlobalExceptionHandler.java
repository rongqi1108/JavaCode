package com.rong.exception;

import com.rong.constants.StatusCodeEnum;
import com.rong.pojo.vo.CommonResult;
import com.rong.pojo.vo.Void;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: RQ
 * @Date: 2023-02-17 12:53:11
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.rong.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public CommonResult<Void> serviceExceptionHandler(ServiceException ex) {
        StatusCodeEnum statusInfo = ex.getStatusInfo();
        return CommonResult.error(statusInfo, null);
    }

    @ExceptionHandler(value = Exception.class)
    public CommonResult<Void> serviceExceptionHandler(Exception ex) {
        log.error("发生异常：", ex);
        return CommonResult.error(StatusCodeEnum.SYS_ERROR, null);
    }


}
