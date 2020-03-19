

mybatis  代码生成
controller  注解验证 、   开启方法验证 、分组验证
controller  异常处理
controller  返回统一格式json

菜单树生成
中文乱码  解决    web.xml 编码filter

登录验证拦截器

使用lombok 简化

考虑 使用bean 映射  mapstruct 、 jmapper、dozer

分页请求


尝试 抽取 base controller  、base service 、base dao

增加 deleteByIdInBatch

封装 study.yzl.com.web.controller.CommonController.validPara(String, R)   方法
使用代码实现统一的验证 

验证分组类  位置 ：study.yzl.com.web.SysConstants.VALIDATE_GROUP_PACKAGE  + XxxController+ XxxMethod 

第一次 动态加载  验证类
没有找到对应的验证类  则不适用验证分组类


是不是可以考虑 用aop 实现方法的动态调用  --  动态代理 不是继承 ？

或者 采用 组合的方式使用 base controller

@Controller
public class NewController {
    // Autowired fields
    BaseController base;

    protected x toExtend() {
         base.toExtend();
         //new stuff
    }
}



考虑 验证分类的 分开问题  在一个类里有些乱



动态获取当前的方法名


id 回填



增加 swagger 配置 :   

swagger 配置类:     study.yzl.com.web.SwaggerConfig
http://127.0.0.1:9090/demo1/swagger-ui.html

spring-mvc.xml  增加：
	 
	 <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
    <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>

 pom.xml  增加：
  <dependency>
		    <groupId>io.springfox</groupId>
		    <artifactId>springfox-swagger2</artifactId>
		    <version>2.4.0</version>
		 </dependency>
        <dependency>
		    <groupId>io.springfox</groupId>
		    <artifactId>springfox-swagger-ui</artifactId>
		    <version>2.4.0</version>
        </dependency>
	    
	    
		<!-- jackson用于将springfox返回的文档对象转换成JSON字符串 -->
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-annotations</artifactId>
		    <version>${version.jackson}</version>
		</dependency>
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-databind</artifactId>
		    <version>${version.jackson}</version>
		</dependency>
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-core</artifactId>
		    <version>${version.jackson}</version>
		</dependency>
	    <!-- jackson end -->



springfox   可以参考    https://github.com/springfox/springfox-demos

----------------------------------------------------------------


1、springfox 版本升级为 2.8.0    
2、练习使用 swagger注解    
3、swagger  返回对象 的泛型问题  
4、swagger  返回 date 格式问题  
5、swagger  中 @ApiImplicitParam(name="id",value="station id",dataType="integer", paramType = "query",allowEmptyValue = false)  
                      的  paramType = "query" 值得是这种传参方式 http://localhost:9090/demo1/station2/removeById?id=23
                      测试在swagger中paramType = "query"  有时问题       
            post 传参的话 还是用  paramType = "form"  吧  
            
6、去掉swagger的 默认的状态码  ：
        return new Docket(DocumentationType.SWAGGER_2)  
        		.useDefaultResponseMessages(false)//去掉swagger默认的状态码              
            
7、StationController2   手写      增加swagger  注解    熟悉swagger注解  

8、CommonController  这种   父类的方式  不是太好  
      一是   因为 父类的 mapping 方法   都会继承到 子类       子类controller了  增加了对外暴露   风险变大
      二是   直接写controller 方法更加灵活  
      
----------------------------------------------------------------

demo3  改成 java  config

删除  web.xml   spring-mvc.xml   spring-context.xml    
完成java config  配置改造  
注意点:   
1、jdbc.properties  文件里的变量最好为 jdbc.XXX
jdbc.driver=  
jdbc.url=  
jdbc.username=  
jdbc.password=  

如果使用 username 的话  发现druid 数据源 获取到的是 操作系统的  当前用户 Administrator  --- 疑惑了好大一会

2、DruidConfig  单独配置一个java类    负责似乎 总是注入 变量有问题 ：  
	@Value("${jdbc.driver}")  
	private String driver;   取不到值 
	
3、注意配置  事物管理器：   

	@Bean
	public DataSourceTransactionManager txManager(DataSource dataSource) throws SQLException {
		
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource);
		AnnotationTransactionAspect.aspectOf().setTransactionManager(txManager);// 注意
		return txManager;
	}
	
4、注意   org.apache.ibatis.session.SqlSessionFactory 的配置  使用resolver

    @Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);

		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
		String mapperLocation = "classpath:mapper/*.xml";
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocation));

		return sqlSessionFactoryBean.getObject();
	}	


5、注意两个 @ComponentScan 的配置  


6、WebAppInitializer 直接继承    配置省事

   WebAppInitializer   extends AbstractAnnotationConfigDispatcherServletInitializer

7、哎  不容易    搞了好几个小时 	





      
      
            


