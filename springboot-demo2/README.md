

1、不使用 继承的方式  配置 pom   
   配置  dependencyManagement   



<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-dependencies</artifactId>
				<version>1.5.22.RELEASE</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>


2、spring boot maven plugin

spring-boot:run          to run our boot application in the exploded form.
spring-boot:repackage    to package executable jar and war files.



配置了下面的<execution> ,   mvn package  会生成可执行jar

			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<version>1.5.22.RELEASE</version>
				<executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
			</plugin>


3、可以指定 启动类 mainClass  

<plugin>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-maven-plugin</artifactId>
     <version>1.4.2.RELEASE</version>
     <configuration>
         <mainClass>com.logicbig.example.MainClass</mainClass>
     </configuration>
</plugin>

4、@EnableAutoConfiguration   根据已经加载的jar 进行自动配置 



5、 @ComponentScan 

若 @ComponentScan  没有指定包    怎会扫描 声明@ComponentScan 的类 所在的包


6、@SpringBootApplication 注解组合了下面的三个注解  
@SpringBootConfiguration  
@EnableAutoConfiguration  
@ComponentScan  


7、通过 SpringApplication 对象 可以设置  启动的一些 行为

 		SpringApplication app = new SpringApplication(CustomBannerExample.class);
        app.setLogStartupInfo(false);

8、自动配置的原理

   8.1  @Import     
                   在应用中，有时没有把某个类注入到IOC容器中，但在运用的时候需要获取该类对应的bean，此时就需要用到@Import注解  
                   
        @Import  也可以导入一个配置类             
             
   8.2   @EnableAutoConfiguration   @import 了   EnableAutoConfigurationImportSelector 
     
        EnableAutoConfigurationImportSelector 实现了  DeferredImportSelector
         
        EnableAutoConfigurationImportSelector  会使用 pring core的 SpringFactoriesLoader.loadFactoryNames() 
         
                     来加载  META-INF/spring.factories  里面配置的类 
                     
   8.3   The boot configuration classes 会从   are loaded from spring-boot-autoconfigure-1.4.2.RELEASE.jar!/META-INF/spring.factories 加载类
   
                      会在spring.factories 文件中 查找 key 为org.springframework.boot.autoconfigure.EnableAutoConfiguration  配置的类
                      
                      
  8.4     下面是 8.3 加载的一个配置类    示例
  
		 @Configuration
		 @ConditionalOnClass({ MBeanExporter.class })
		 @ConditionalOnProperty(prefix = "spring.jmx", name = "enabled", havingValue = "true", matchIfMissing = true)
		 public class JmxAutoConfiguration implements                    
		                      
                     看到 这里的   @ConditionalOnClass         @ConditionalOnProperty   
                   
                              
       @ConditionalOnClass -- 存在某个类时   才注册     被@ConditionalOnClass注解的 配置类
       
       @ConditionalOnProperty -- 存在某些配置属性时    才注册 配置类
       
                   被加载的配置类 根据配置的条件决定是否 注册
                   
 8.5    禁止某个自动配置  :  
        @EnableAutoConfiguration(exclude = {JmxAutoConfiguration.class})                         
       
       
       













4、
















