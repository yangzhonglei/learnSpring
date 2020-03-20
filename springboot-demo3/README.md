
1、默认情况息  Spring boot web静态文件  放在 类路径下的:              
/static  
/public  
/resources  
/META-INF/resources  

在eclipse工程里看的话就是在  /main/resources 下
/main/resources/static 
/main/resources/public 
/main/resources/resources
/main/resources/META-INF/resources 
 


2、 替换默认配置   配置属性"spring.resources.static-locations"
   public static void main (String[] args) {

        SpringApplication app = new SpringApplication(ReplaceDefaultLocationsExample.class);
        Properties properties = new Properties();
        properties.setProperty("spring.resources.static-locations","classpath:/newLocation1/,classpath:/newLocation2/");
        app.setDefaultProperties(properties);
        app.run(args);
    }


3、使用jsp

   3.1添加依赖  
   	<!-- JSP related maven dependencies   begin -->  
	<dependency>  
		<groupId>org.apache.tomcat.embed</groupId>  
		<artifactId>tomcat-embed-jasper</artifactId>  
	</dependency>  
	<dependency>  
		<groupId>javax.servlet</groupId>  
		<artifactId>jstl</artifactId>  
	</dependency>  
	<!-- JSP related maven dependencies  end  -->  
	
	3.2 application.properties
	 增加属性配置  
	 spring.mvc.view.prefix= /WEB-INF/views/
	 spring.mvc.view.suffix= .jsp
	 
	 3.3  新建 jsp 在  resources/META-INF/resources/WEB-INF/views/myView.jsp  --- 注意位置
	 
	 3.4 controller  
	     	@RequestMapping("/")
			public String handler(Model model) {
				model.addAttribute("msg", "a jar packaging example");
				return "myView";
			}
	 
4、更换图标的话 放在  src/main/resources/favicon.ico




5、	 HttpMessageConverter
	 
![HttpMessageConverter](./src/main/resources/static/images/HttpMessageConverter.png)

自定义个       HttpMessageConverter :    com.yzl.study.spingboot.HttpMessageConverterConfig




6、 @ServletComponentScan  可以用来扫描  @WebServlet, @WebFilter and @WebListener  


7、不适用  @ServletComponentScan的话    可以直接  把 Servlet  等注册为 spring一个bean  来使用    

pring provides following classes to register servlet components as beans.

ServletRegistrationBean
FilterRegistrationBean
ServletListenerRegistrationBean


8、BeanNameViewResolver 默认会被注册  
  我们可以拿   View's bean name 作为 view name
  View's bean ： com.yzl.study.spingboot.MyCustomView
  
9、  
  














