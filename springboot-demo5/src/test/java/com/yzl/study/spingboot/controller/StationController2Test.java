package com.yzl.study.spingboot.controller;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.yzl.study.spingboot.model.Station;
import com.yzl.study.spingboot.service.StationServiceImplTest;
import com.yzl.study.spingboot.util.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class StationController2Test {
	
	
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
	public void queryByIdTest() throws URISyntaxException {

		String body = "id=1";
		RequestEntity request = RequestEntity.post(new URI("queryById"))
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON).body(body);
//		ResponseEntity<ResponseMessage> response = this.restTemplate.exchange(request, ResponseMessage.class);

	
		
		ResponseEntity<ResponseMessage> response= this.restTemplate.postForObject("/queryById", request, ResponseEntity.class) ;
//		ResponseMessage rmg = response.getBody();
		assertEquals(200,response.getStatusCode());
		ResponseMessage rmg = response.getBody();
		assertEquals("SUCCESS", rmg.getStatus());
		Station s = (Station) rmg.getData();
		assertEquals(Integer.valueOf(1), s.getId());
    
    }
		
		

}
