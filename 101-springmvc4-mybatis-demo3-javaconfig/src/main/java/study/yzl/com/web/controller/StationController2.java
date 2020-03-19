package study.yzl.com.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import study.yzl.com.model.Station;
import study.yzl.com.service.StationService;
import study.yzl.com.utils.ResponseMessage;
import study.yzl.com.web.Page;
import study.yzl.com.web.vo.StationRequestVO;

@Controller
@Slf4j
@RequestMapping("/station2")
@Validated
public class StationController2 {
	
	
	private static     BeanCopier beanCopierStationRequestVO2Station =BeanCopier.create(StationRequestVO.class,Station.class,false);
	
	
	@Autowired
	private StationService stationService ;
	
	@Autowired()
	@Qualifier("cacheManager")
	private SimpleCacheManager cacheManager ;
	
	
	@ResponseBody
    @ApiOperation(value = "Add a new station ", nickname = "addStation", notes = "新建一个station", tags={ })
	@ApiResponses(value = {@ApiResponse(code = 200, message = "{\"status\": \"FAIL\",\"msg\": \"处理失败\",\"data\": null}")})
	@RequestMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseMessage<Station> addOne(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true ) 
	                     @Validated @RequestBody  
	                     StationRequestVO stationRequestVO) {
		
		Station  station = new Station();
		//beanCopier.copy(from, to, null);
		beanCopierStationRequestVO2Station.copy(stationRequestVO, station, null);
		int i = stationService.create(station);
		return ResponseMessage.successMessage(null);
	}
	
	@RequestMapping(value = "/removeById", method = RequestMethod.POST,consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE},produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	@ApiOperation(value = "delete a station ", nickname = "deleteStation", notes = "根据id删除一个station", tags={ })
	@ApiResponses(value = {@ApiResponse(code = 200, message = "{\"status\": \"FAIL\",\"msg\": \"处理失败\",\"data\": null}")})
	@ApiImplicitParam(name="id",value="station id",dataType="integer", paramType = "form",allowEmptyValue = false)
	public ResponseMessage removeById(/* @ApiParam(value = "station id " ,required=true,example = "id=6" ) */
	                                  @Validated @NotNull(message = "id不可为空") 
	                                  @Digits(integer = 7, fraction = 0) 
	                                  @RequestParam
	                                  Integer id) {

		int i  = stationService.remove(id);
        if(i==1) {
        	Integer integer;
        	
        	return ResponseMessage.successMessage(null);
        }else {
        	return ResponseMessage.failMessage("删除失败");
        }
	}
	
	@RequestMapping(value = "/removeByIds", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@ApiOperation(value = "delete some station ", nickname = "deleteSomeStation", notes = "根据id数组删除station", tags={ })
	@ApiResponses(value = {@ApiResponse(code = 200, message = "{\"status\": \"FAIL\",\"msg\": \"处理失败\",\"data\": null}")})
	@ApiImplicitParam(name="ids",value="station数组",dataType="Array", paramType = "form")
	public ResponseMessage removeByIds(/* @ApiParam(value = "station ids " ,required=true,example = "ids=6,7,8" ) */
			
	                                   @Validated  @Size(min = 1) 
	                                   Integer[] ids) {
		
		List<Integer> list = Arrays.asList(ids);
		int i  = stationService.deleteByIdInBatch(list);
		
		return ResponseMessage.successMessage(null);
		
	}
	
	@ApiOperation(value = "update a station", nickname = "updateStation", notes = "更新station", tags={ })
	@ApiResponses(value = {@ApiResponse(code = 200, message = "{\"status\": \"FAIL\",\"msg\": \"处理失败\",\"data\": null}")})
	@RequestMapping(value = "/updateById", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseMessage updateById(@ApiParam(value = "" ,required=true,allowEmptyValue = false ) 
	                                  @Validated  @RequestBody StationRequestVO requestVO) {
		
		Station  station = new Station();
		beanCopierStationRequestVO2Station.copy(requestVO, station, null);
		
		int i = stationService.updateByIdSelective(station);
	     if(i==1) {
	        	return ResponseMessage.successMessage(null);
	        }else {
	        	return ResponseMessage.failMessage("更新失败");
	        }
	}
	
	
    @ApiOperation(value = "Find station by ID", nickname = "getStationById", notes = "Returns a single station", response = Station.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Station.class)})
	@RequestMapping(value = "/queryById", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name="id",value="",dataType="integer", paramType = "form")
	@ResponseBody
	public ResponseMessage<Station> queryById( @Validated @NotNull(message = "id不可为空") @Digits(integer = 7, fraction = 0) Integer id) {
		
		Object station = stationService.queryById(id);
		
		return ResponseMessage.successMessage(station);
	}
	
	
    
  //TODO  这样写在父类里面 有风险
    @ApiOperation(value = "Find all paged", nickname = "listPaged", notes = "Returns  station list")
   	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation")})
  	@RequestMapping(value = "/listPaged", method = RequestMethod.POST)
  	@ResponseBody
  	public ResponseMessage<List<Station>> listPaged(@Validated  @RequestBody Page  page) {
  		
  		
//  		String currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//  		ValidationResult result = validPara(currentMethodName, requestVO);
//  		if (result.isHasErrors()) {
//  			String errMsg = ValidationUtils.getFirstErrMsg(result);
//  			return ResponseMessage.failMessage(errMsg);
//  		}
  		
  		
  		List<Station> list = stationService.queryAllPaged(page);
  		
  		return ResponseMessage.successMessage(list);
  	}
  	
  	
  	

}
