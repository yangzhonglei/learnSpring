package com.yzl.study.spingboot.util;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="ResponseMessage" )
public class ResponseMessage<T>
{

    public static ResponseMessage failMessage(String message)
    {
        return new ResponseMessage(FAIL, message);
    }
    public static ResponseMessage failMessage()
    {
    	return new ResponseMessage(FAIL, FAIL_MSG);
    }

    public static ResponseMessage successMessage(String message, Object data)
    {
        return new ResponseMessage(SUCCESS, message, data);
    }
    public static ResponseMessage successMessage(Object data)
    {
    	return new ResponseMessage(SUCCESS, SUCCESS_MSG, data);
    }

    public static final String SUCCESS = "SUCCESS";

    public static final String SUCCESS_MSG = "成功";
    
    public static final String FAIL = "FAIL";
    public static final String FAIL_MSG = "失败";

    @ApiModelProperty(example = "SUCCESS")
    private String status = FAIL;

    @ApiModelProperty(example = "成功")
    private String msg = null;

    @ApiModelProperty(allowEmptyValue = true)
    //data 不是 null时 才返回 data字段
    @JsonInclude( com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL )
    private T data = null;

    private ResponseMessage()
    {
    }

    private ResponseMessage(String status, String message, T data)
    {
        this.status = status;
        this.msg = message;
        this.data = data;
    }

    private ResponseMessage(String status, String message)
    {
        this(status, message, null);
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String message)
    {
        this.msg = message;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    
    
}
