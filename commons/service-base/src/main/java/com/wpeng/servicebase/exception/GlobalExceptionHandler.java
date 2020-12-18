package com.wpeng.servicebase.exception;

import com.wpeng.commonutils.api.APICODE;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wpeng
 * @version 1.0
 * @date 2020/12/18 10:47
 *
 * 统一异常数据格式返回
 */
@ControllerAdvice //controller异常通知 拦截注解
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler
    public APICODE errorHandler(Exception e) {
        e.printStackTrace();
        return APICODE.SORRY()
                .message("服务器异常：Exception");
    }


    @ResponseBody
    @ExceptionHandler
    public APICODE errorHandler(WpengException we) {
        we.printStackTrace();
        return APICODE.SORRY()
                .code(we.getCode())
                .message(we.getMessage());
    }

}
