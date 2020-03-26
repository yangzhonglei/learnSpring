package com.yzl.study.logindemo.controller;


import com.yzl.study.logindemo.util.ResponseResult;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("validCode")
public class ValidCodeController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate ;

     @GetMapping("/getValidCode")
     public Object getValidCode(@Validated  @NotBlank  String cellPhone){

        String cachedCode = (String) redisTemplate.opsForValue().get(cellPhone);
        //已经有缓存的 就返回缓存的
        if(cachedCode!=null){
            return ResponseResult.successMsg(cachedCode);
        }
         //生成随机码
         String code = RandomStringUtils.randomNumeric(6);
         //把手机号：随机码放入 redis
         redisTemplate.opsForValue().set(cellPhone,code, 3, TimeUnit.MINUTES);
         return ResponseResult.successMsg(code);
     }
}