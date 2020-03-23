package com.yzl.study.logindemo.util;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseResult {

    private static  final String SUCCESS ="SUCCESS";
    private static  final String SUCCESS_MSG ="成功";

    private static  final String FAIL ="FAIL";
    private static  final String FAIL_MSG ="失败";

    private  String status;
    private  String msg;

    @JsonInclude( com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL )
    private  Object data ;


    public static ResponseResult successMsg(){

        return new ResponseResult(SUCCESS, SUCCESS_MSG, null);
    }
    public static ResponseResult successMsg(String msg){

        return new ResponseResult(SUCCESS, msg,null);
    }
    public static ResponseResult successMsgObject(Object obj){

        return new ResponseResult(SUCCESS, SUCCESS_MSG,obj);
    }
    public static ResponseResult successMsgObject(String msg, Object obj){

        return new ResponseResult(SUCCESS, msg,obj);
    }



    public static ResponseResult failMsg(){

        return new ResponseResult(FAIL, FAIL_MSG, null);
    }
    public static ResponseResult failMsg(String msg){

        return new ResponseResult(FAIL, msg, null);
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private ResponseResult(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    private ResponseResult() {

    }
}
