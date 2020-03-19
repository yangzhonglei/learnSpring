package study.yzl.com.web.controller;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import lombok.extern.slf4j.Slf4j;
import study.yzl.com.utils.ResponseMessage;

@Slf4j
@ControllerAdvice
public class ExceptionConfigController {
    
	@ExceptionHandler
    public ModelAndView exceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        mv.addObject("status",ResponseMessage.FAIL);
        mv.addObject("msg","请求发生了异常，请稍后再试");
        mv.addObject("data",null);
        return mv;
    }
    
    //绑定参数到对象 校验失败会抛出这个异常
    @ExceptionHandler(org.springframework.validation.BindException.class)
    @ResponseBody
    public Object bindExceptionHandler(BindException bindException){
    	
    	String errMsg=bindException.getBindingResult().getFieldError().getDefaultMessage();
    	log.warn("参数校验异常:{}", errMsg);
        return ResponseMessage.failMessage(errMsg) ;
    }
    
    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    @ResponseBody
    public Object constraintViolationExceptionHandler(javax.validation.ConstraintViolationException exception){
    	
    	String errMsg=exception.getMessage();
    	if(errMsg!=null) {
    		
    		int index = errMsg.indexOf(":");
    		if(index!=-1 && index<errMsg.length()) {
    			errMsg=errMsg.substring(index+1);
    		}
    		
    	}
    	log.warn("参数校验异常:{}", errMsg);
    	return ResponseMessage.failMessage(errMsg) ;
    }
    
 
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Object methodArgumentNotValidExceptionHandler(MethodArgumentTypeMismatchException ex) {
    	
        log.warn("参数校验异常:{}", ex.getMessage());
        return ResponseMessage.failMessage(ex.getMessage()) ;
    }
	
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
    	FieldError fieldError = ex.getBindingResult().getFieldError();
    	log.warn("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
    	return ResponseMessage.failMessage(fieldError.getDefaultMessage()) ;
    }
    

    
}