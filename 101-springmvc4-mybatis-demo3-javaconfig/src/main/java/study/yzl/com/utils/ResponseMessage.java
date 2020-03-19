package study.yzl.com.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Result 模型")
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

    public static final String SUCCESS_MSG = "处理成功";
    
    public static final String FAIL = "FAIL";
    public static final String FAIL_MSG = "处理失败";

    //@Expose
    @ApiModelProperty(example = "SUCCESS")
    private String status = FAIL;

   // @Expose
    @ApiModelProperty(example = "处理成功")
    private String msg = null;

    //@Expose
    @ApiModelProperty(allowEmptyValue = true)
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
