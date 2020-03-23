package com.yzl.study.spingboot.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.yzl.study.spingboot.model.Station;
import com.yzl.study.spingboot.service.StationService;
import com.yzl.study.spingboot.util.ResponseMessage;
import com.yzl.study.spingboot.vo.StationRequestVO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/station2")
@Validated
public class StationController2 {
	
	
	private static     BeanCopier beanCopierStationRequestVO2Station =BeanCopier.create(StationRequestVO.class,Station.class,false);
	
	
//	 新增一个             create                    /user/create        		          对象接收参数      post
//	   增加多个             createBatch           /user/createBatch                 对象数组接收       psot
//	   根据id查询一个   findById                 /user/findById          	          简单参数              get
//	   根据某个条件      findrByXxx            /user/findByXx                	简单参数              	get
//	    查询全部            findAll                     /user/findAll                          对象                      get
//	    分页查询            findAllPaged          /user/findAllPaged                 对象                     get
//	     复杂条件查询    findByConditionPage /user/findConditionPaged 对象                  post
//	    多列中search     search                        /user/search                         /                      /                                         
//	   修改1个属性        modifyXxx             	/user/modifyXxx	     	简单参数              post
//	     改多属性     	modify                  	/user/modify                    对象接收              post
//	   根据对象id删除    delById              	/user/delById                   简单参数              post
//	根据id数组删除多个delByIds           	 /user/delByIds                  简单参数数组      psot
	
	
	@Autowired
	private StationService stationService ;
	
	@SuppressWarnings("unchecked")
	@ResponseBody
    @ApiOperation(value = "Add a new station ", nickname = "addStation", notes = "新建一个station", tags={ })
	@ApiResponses(value = {@ApiResponse(code = 200, message = "{\"status\": \"FAIL\",\"msg\": \"失败\"}")})
	@RequestMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseMessage<Station> create(@Validated @RequestBody StationRequestVO stationRequestVO) {
		
		Station  station = new Station();
		//beanCopier.copy(from, to, null);
		beanCopierStationRequestVO2Station.copy(stationRequestVO, station, null);
		int i = stationService.create(station);
		return ResponseMessage.successMessage(station);
	}
	@SuppressWarnings("unchecked")
	@ResponseBody
	@ApiOperation(value = "Add a new station ", nickname = "addStation", notes = "新建一个station", tags={ })
	@ApiResponses(value = {@ApiResponse(code = 200, message = "{\"status\": \"FAIL\",\"msg\": \"失败\"}")})
	@RequestMapping(value = "/createBatch",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseMessage<Station> createBatch(@Validated @RequestBody List<StationRequestVO> stationRequestVOList) {
		
		
		List<Station> StationList = new ArrayList<Station>();
		Station tmpStation ;
		for(StationRequestVO v:stationRequestVOList) {
			
			 tmpStation = new Station();
			 beanCopierStationRequestVO2Station.copy(v, tmpStation, null);
			 StationList.add(tmpStation);
			
		}
		int i = stationService.create(station);
		return ResponseMessage.successMessage(station);
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
	public ResponseMessage updateById( @Validated  @RequestBody StationRequestVO requestVO) {
		
		Station  station = new Station();
		beanCopierStationRequestVO2Station.copy(requestVO, station, null);
		
		int i = stationService.updateByIdSelective(station);
	     if(i==1) {
	        	return ResponseMessage.successMessage(null);
	        }else {
	        	return ResponseMessage.failMessage("更新失败");
	        }
	}
	
	
    @ApiOperation(value = "Find station by ID", nickname = "getStationById", notes = "Returns a single station")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation")})
    @ApiImplicitParam(name="id",value="",dataType="integer", paramType = "path")
    @RequestMapping(value = "/queryById/{id}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseMessage<Station> queryById(
			/* @PathVariable("id") */ @Validated @NotNull(message = "id不可为空") @Digits(integer = 7, fraction = 0)  Integer id) {
		
		Object station = stationService.queryById(id);
		
		return ResponseMessage.successMessage(station);
	}
	
	
    
//  //TODO  这样写在父类里面 有风险
//    @ApiOperation(value = "Find all paged", nickname = "listPaged", notes = "Returns  station list")
//   	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation")})
//  	@RequestMapping(value = "/listPaged", method = RequestMethod.POST)
//  	@ResponseBody
//  	public ResponseMessage<List<Station>> listPaged(@Validated  @RequestBody Page  page) {
//  		
//  		
////  		String currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
////  		ValidationResult result = validPara(currentMethodName, requestVO);
////  		if (result.isHasErrors()) {
////  			String errMsg = ValidationUtils.getFirstErrMsg(result);
////  			return ResponseMessage.failMessage(errMsg);
////  		}
//  		
//  		
//  		List<Station> list = stationService.queryAllPaged(page);
//  		
//  		return ResponseMessage.successMessage(list);
//  	}
//  	
  	
  	

}
