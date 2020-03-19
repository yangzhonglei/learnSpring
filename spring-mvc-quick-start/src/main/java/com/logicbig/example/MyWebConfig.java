package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration //  说明这个类    相当于 xml 配置的一个配置文件
@EnableWebMvc //   相当于xml的<mvc:annotation-driven>
public class MyWebConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //commenting next line, setViewClass, as by
        // default the resolver's view is the same
        //viewResolver.setViewClass(JstlView.class);

        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public MyMvcController myMvcController() {
        return new MyMvcController();
    }
}