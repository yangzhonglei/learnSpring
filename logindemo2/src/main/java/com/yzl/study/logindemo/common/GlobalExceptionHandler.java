package com.yzl.study.logindemo.common;

import com.yzl.study.logindemo.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BindException.class)
    public ResponseResult bindExceptionHandler(BindException e) {
        String msg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        log.error("绑定参数失败", msg);
        return ResponseResult.failMsg(msg) ;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        log.error("绑定参数失败", msg);
        return ResponseResult.failMsg(msg) ;
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseResult businessExceptionHandler(Exception e) {
        log.error("发生业务异常");
        return ResponseResult.failMsg(e.getMessage()) ;
    }


   @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e) {
        log.error("发生其他异常",e);
        return ResponseResult.failMsg("系统异常") ;
    }



}