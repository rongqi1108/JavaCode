package com.rong.exception;

import com.rong.constants.StatusCodeEnum;
import com.rong.pojo.vo.CommonResult;
import com.rong.pojo.vo.Void;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

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

    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult<Void> constraintViolationExceptionHandler(HttpServletRequest req, ConstraintViolationException ex) {
        // 拼接错误
        StringBuilder detailMessage = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
            // 使用 ; 分隔多个错误
            if (detailMessage.length() > 0) {
                detailMessage.append(";");
            }
            // 拼接内容到其中
            detailMessage.append(constraintViolation.getMessage());
        }
        // 包装 CommonResult 结果
        return CommonResult.error(StatusCodeEnum.MISSING_REQUEST_PARAM_ERROR,detailMessage.toString());
    }

    @ExceptionHandler(value = BindException.class)
    public CommonResult<Void> bindExceptionHandler(HttpServletRequest req, BindException ex) {
        // 拼接错误
        StringBuilder detailMessage = new StringBuilder();
        for (ObjectError objectError : ex.getAllErrors()) {
            // 使用 ; 分隔多个错误
            if (detailMessage.length() > 0) {
                detailMessage.append(";");
            }
            // 拼接内容到其中
            detailMessage.append(objectError.getDefaultMessage());
        }
        // 包装 CommonResult 结果
        return CommonResult.error(StatusCodeEnum.MISSING_REQUEST_PARAM_ERROR, detailMessage.toString());
    }

}
