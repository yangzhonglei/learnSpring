package study.yzl.com.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import study.yzl.com.model.SysUser;
import study.yzl.com.service.BaseService;
import study.yzl.com.utils.ResponseMessage;
import study.yzl.com.web.Page;
import study.yzl.com.web.SysConstants;
import study.yzl.com.web.ValidationResult;
import study.yzl.com.web.ValidationUtils;
import study.yzl.com.web.vo.RequestVO;
import study.yzl.com.web.vo.UserRequestVO;
import study.yzl.com.web.vo.validateGroup.UserFindByConditionPaged;

@Slf4j
public abstract class CommonController<R extends RequestVO ,T  extends Object> {

	@Autowired()
	@Qualifier("cacheManager")
	private SimpleCacheManager cacheManager;

	/**
	 * * 获取基础的服务
	 * 
	 * @return BaseService
	 */
	protected abstract BaseService<T> getBaseService();
	
	public abstract T getEntityInstance();  
	 
	public abstract void createEntityProcesss(T entityObject);

	@PostMapping(path = "/create")
	@ResponseBody
	public Object create(R requestVO) {
		String currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		ValidationResult result = validPara(currentMethodName, requestVO);
		if (result.isHasErrors()) {
			String errMsg = ValidationUtils.getFirstErrMsg(result);
			return ResponseMessage.failMessage(errMsg);
		}
		
		T entityObject = getEntityInstance();
		
//		BeanCopier.create(requestVO, entityObject, false);
		
		try {
			PropertyUtils.copyProperties(entityObject, requestVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createEntityProcesss(entityObject);
		getBaseService().create(entityObject);
		return ResponseMessage.successMessage(requestVO);
	}

	@RequestMapping(value = "/removeById", method = RequestMethod.POST)
	@ResponseBody
	public Object removeById(@Validated @NotNull(message = "id不可为空") @Digits(integer = 7, fraction = 0) Integer id) {

		int i  = getBaseService().remove(id);
        if(i==1) {
        	
        	return ResponseMessage.successMessage(null);
        }else {
        	return ResponseMessage.failMessage("删除失败");
        }
	}
	@RequestMapping(value = "/removeByIds", method = RequestMethod.POST)
	@ResponseBody
	public Object removeByIds(@Validated  @Size(min = 1) Integer[] ids) {
		
		List<Integer> list = Arrays.asList(ids);
		int i  = getBaseService().deleteByIdInBatch(list);
		
		return ResponseMessage.successMessage(null);
		
	}
	

	
	@RequestMapping(value = "/updateById", method = RequestMethod.POST)
	@ResponseBody
	public Object updateById(@Validated R requestVO) {
		
		
		String currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		ValidationResult result = validPara(currentMethodName, requestVO);
		if (result.isHasErrors()) {
			String errMsg = ValidationUtils.getFirstErrMsg(result);
			return ResponseMessage.failMessage(errMsg);
		}
		
		T entityObject = getEntityInstance();
		try {
			PropertyUtils.copyProperties(entityObject, requestVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateEntityProcesss(entityObject);
		int i = getBaseService().updateById(entityObject);
	     if(i==1) {
	        	
	        	return ResponseMessage.successMessage(null);
	        }else {
	        	return ResponseMessage.failMessage("更新失败");
	        }
	}

	
	@RequestMapping(value = "/updateByIdSelective", method = RequestMethod.POST)
	@ResponseBody
	public Object updateByIdSelective(@Validated R requestVO) {
		
		
		String currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		ValidationResult result = validPara(currentMethodName, requestVO);
		if (result.isHasErrors()) {
			String errMsg = ValidationUtils.getFirstErrMsg(result);
			return ResponseMessage.failMessage(errMsg);
		}
		
		T entityObject = getEntityInstance();
		try {
			PropertyUtils.copyProperties(entityObject, requestVO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateEntitySelectiveProcesss(entityObject);
		int i = getBaseService().updateByIdSelective(entityObject);
		if(i==1) {
			
			return ResponseMessage.successMessage(null);
		}else {
			return ResponseMessage.failMessage("更新失败");
		}
	}
	
	
	@RequestMapping(value = "/queryById", method = RequestMethod.POST)
	@ResponseBody
	public Object queryById(@Validated @NotNull(message = "id不可为空") @Digits(integer = 7, fraction = 0) Integer id) {
		
		Object station = getBaseService().queryById(id);
		
		return ResponseMessage.successMessage(station);
	}
	
	
	//TODO  这样写在父类里面 有风险
	@RequestMapping(value = "/listPaged", method = RequestMethod.POST)
	@ResponseBody
	public Object queryById(@Validated @RequestBody Page<List<T>> page) {
		
		
//		String currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//		ValidationResult result = validPara(currentMethodName, requestVO);
//		if (result.isHasErrors()) {
//			String errMsg = ValidationUtils.getFirstErrMsg(result);
//			return ResponseMessage.failMessage(errMsg);
//		}
		
		
		List<T> list = getBaseService().queryAllPaged(page);
		
		return ResponseMessage.successMessage(list);
	}
	
//	@RequestMapping(value = "/queryListPage", method = RequestMethod.POST)
//	@ResponseBody
//	public Object queryListPage(@Validated @NotNull(message = "id不可为空") @Digits(integer = 7, fraction = 0) Integer id) {
//		
////		Object station = getBaseService().
//		
//		return ResponseMessage.successMessage(station);
//	}
//	
//	public int  create(T entity);
//	public int remove(Integer id);
//	public int  deleteByIdInBatch(List<Integer> list);
//	public int  updateById(T entity);
//	public int  updateByIdSelective(T entity);
//	public List<T> queryPageList(T query, Page  page);
	
	
	
	
	
	
	
	
	protected abstract void updateEntitySelectiveProcesss(T entityObject);

	protected abstract void updateEntityProcesss(T entityObject);

	private ValidationResult validPara(String currentMethodName, R station) {

		ValidationResult result = null;
		String ValidateGroupClassName = getValidateGroupClassName(currentMethodName);
		System.out.println("===========================" + ValidateGroupClassName);
		Class<?> validateGroupClass = getGRoup(ValidateGroupClassName);
		if (validateGroupClass == null) {
			result = ValidationUtils.validateEntity(station);
		} else {
			result = ValidationUtils.validateEntity(station, validateGroupClass);
		}
		return result;
	}

	private Class<?> getGRoup(String validateGroupClassName) {

		ValueWrapper vm = cacheManager.getCache("springMapCache").get(validateGroupClassName);
		if (vm != null) {
			Class clazz = (Class) vm.get();
			return clazz;
		}
		Class<?> clz = null;
		try {
			clz = Class.forName(validateGroupClassName);
		} catch (ClassNotFoundException e) {
			log.warn("can not find validate group class ,class name:{}", validateGroupClassName);
		}
		cacheManager.getCache("springMapCache").put(validateGroupClassName, clz);
		return clz;
	}

	private String getValidateGroupClassName(String currentMethodName) {

		String classFullName = Thread.currentThread().getStackTrace()[1].getClassName();
//		String clasShortName = classFullName.substring(classFullName.lastIndexOf(".") + 1);
		String clasShortName = getClassShortName();
		String currentMethodNameUpper = StringUtils.capitalize(currentMethodName);
		String validateGroupClassName = SysConstants.VALIDATE_GROUP_PACKAGE + clasShortName + currentMethodNameUpper;
		return validateGroupClassName;
	}

	protected abstract String getClassShortName();
}
