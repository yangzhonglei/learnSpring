package com.yzl.study.spingboot;
import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@ServletComponentScan
@EnableTransactionManagement
@SpringBootApplication
@MapperScan({"com.yzl.study.**.dao"})  
public class Application {
	
	
    public static void main (String[] args) {
    	
        ApplicationContext ctx =  SpringApplication.run(Application.class, args);
    	
//        SpringApplication app = new SpringApplication(HelloWorldApplication.class);
//        app.run(args);
        System.out.println("================startup success===================");
    }
    
    
    //注册  servlet 为spring的  bean  
    @Bean
    ServletRegistrationBean myServletRegistration () {
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new MyServlet());
        srb.setUrlMappings(Arrays.asList("/path2/*"));
        return srb;
    }
    
    //注册 filter 为spring的 bean
    @Bean
    FilterRegistrationBean myFilterRegistration () {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new MyFilter());
        frb.setUrlPatterns(Arrays.asList("/*"));
        return frb;
    }
    
    
 
    
    
}