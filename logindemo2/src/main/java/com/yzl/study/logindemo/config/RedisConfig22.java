//package com.yzl.study.logindemo.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//@EnableCaching
//public class RedisConfig {
//
//    //配置使用jedis作为redis的客户端
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(){
//        return new JedisConnectionFactory();
//    }
//
//
//    @Bean
//    public RedisTemplate<Object,Object> redisTemplate(){
//        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
//        template.setConnectionFactory(redisConnectionFactory());
//
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =
//                new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//
//        template.afterPropertiesSet();
//        return template;
//    }
//
//}