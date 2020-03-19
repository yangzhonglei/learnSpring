package study.yzl.com.web;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* Swagger配置文件。
* [Springfox官方集成文档](http://springfox.github.io/springfox/docs/current/)
* [Swagger注解官方文档](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)
* <p>
* 配置注意事项：
* 1. swagger及swagger-ui的添加，注意版本
* 2. 该config文件的注解添加，@Configuration与@EnableSwagger2为必须添加
* 3. 配置servlet-mapping为"/"，因为会生成静态文件，因此需要注意路径穿透
*
*/
@Configuration
@EnableSwagger2
//To enable MVC Java config add the annotation @EnableWebMvc to one of your @Configuration classes
@EnableWebMvc
@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {

    /**
    * 根据配置读取是否开启swagger文档，针对测试与生产环境采用不同的配置
    */
    @Value("${swagger.enable}")
    private boolean isSwaggerEnable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.useDefaultResponseMessages(false)//去掉swagger默认的状态码
                .groupName("sanchi")
                .enable(isSwaggerEnable)
                .apiInfo(apiInfo()).select()
                // 对所有该包下的Api进行监控，如果想要监控所有的话可以改成any() .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("study.yzl.com"))
                // 对所有路径进行扫描
                .paths(PathSelectors.any())
                .build();
    }

    /**
    * @return 生成文档说明信息
    */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("yzl test API文档")
                .description("接口文档")
//                .termsOfServiceUrl("http://sanchips.github.io")
                .version("1.0.0").build();
    }
}