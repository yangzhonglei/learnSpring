package com.yzl.study.spingboot;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


//@ServletComponentScan
@SpringBootApplication
public class Application {
    public static void main (String[] args) {
    	
        ApplicationContext ctx =  SpringApplication.run(Application.class, args);
    	
    	
//        SpringApplication app = new SpringApplication(HelloWorldApplication.class);
//        app.run(args);

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