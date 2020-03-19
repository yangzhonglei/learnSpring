package study.yzl.com.mybatis1.web.controller;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import study.yzl.com.DruidConfig;
import study.yzl.com.SpringRootConfig;
import study.yzl.com.WebConfig;
import study.yzl.com.web.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class,DruidConfig.class,SpringRootConfig.class})
@Slf4j
public class StationController2Test {

	
	
	 	@Autowired
	    private WebApplicationContext wac;
	    private MockMvc mockMvc;

	    @Before
	    public void setup() {
	        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
	        this.mockMvc = builder.build();
	    }
	    
	    
	    @Test
	    public void listPagedTest() throws Exception {
	        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
	        ResultMatcher msg = MockMvcResultMatchers.model()
	                            .attribute("msg", "Spring quick start!!");

	        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/station2/listPaged");
	        final int pageSize = 3 ;
	        Page page = new Page(1, pageSize, null, null);
	        
	        builder.content(JSON.toJSONString(page)).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
	        final int resultSize;
	        ResultActions acs =  this.mockMvc.perform(builder);
	        acs.andExpect(ok);
	        acs.andDo(new ResultHandler() {
				
				@Override
				public void handle(MvcResult result) throws Exception {
					 
					String jsonStr = result.getResponse().getContentAsString();
					log.info("====result json===="+jsonStr);
					JSONObject  jsonObj = JSON.parseObject(jsonStr);
					JSONArray jsa = jsonObj.getJSONArray("data");
					assertEquals(pageSize, jsa.size());
				}
			});
	       
	     }
	    
	    
	    
	    
	
	
	
}
