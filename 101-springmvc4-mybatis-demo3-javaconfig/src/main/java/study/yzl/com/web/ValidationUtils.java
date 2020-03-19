package study.yzl.com.web;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import com.alibaba.fastjson.JSON;

import study.yzl.com.utils.ResponseMessage;
 
/**
 * 校验工具类
 * 
 * @author lizhilong
 */
public class ValidationUtils {
 
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
 
    public static <T> ValidationResult validateEntity(T obj) {
        ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        // if( CollectionUtils.isNotEmpty(set) ){
        if (set != null && set.size() != 0) {
            result.setHasErrors(true);
            Map<String, String> errorMsg = new HashMap<String, String>();
            for (ConstraintViolation<T> cv : set) {
                errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
            }
            result.setErrorMsg(errorMsg);
        }
        return result;
    }
    public static <T> ValidationResult validateEntity(T obj ,Class groupClass) {
    	ValidationResult result = new ValidationResult();
    	Set<ConstraintViolation<T>> set = validator.validate(obj, groupClass);
    	// if( CollectionUtils.isNotEmpty(set) ){
    	if (set != null && set.size() != 0) {
    		result.setHasErrors(true);
    		Map<String, String> errorMsg = new HashMap<String, String>();
    		for (ConstraintViolation<T> cv : set) {
    			errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
    		}
    		result.setErrorMsg(errorMsg);
    	}
    	return result;
    }
 
    public static <T> ValidationResult validateProperty(T obj, String propertyName) {
        ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<T>> set = validator.validateProperty(obj, propertyName, Default.class);
        if (set != null && set.size() != 0) {
            result.setHasErrors(true);
            Map<String, String> errorMsg = new HashMap<String, String>();
            for (ConstraintViolation<T> cv : set) {
                errorMsg.put(propertyName, cv.getMessage());
            }
            result.setErrorMsg(errorMsg);
        }
        return result;
    }
    
    
    public static String  getFirstErrMsg(ValidationResult  result){
    	
    	String resiult = null;
        Map<String, String> map = result.getErrorMsg();
  	   for(Entry<String, String> e: map.entrySet()) {
  		   
  		   resiult= e.getValue();
  		   break;
  	   }
  	   
    	return resiult;
    }
    
}
