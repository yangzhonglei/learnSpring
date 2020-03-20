

1����ʹ�� �̳еķ�ʽ  ���� pom   
   ����  dependencyManagement   



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


2��spring boot maven plugin

spring-boot:run          to run our boot application in the exploded form.
spring-boot:repackage    to package executable jar and war files.



�����������<execution> ,   mvn package  �����ɿ�ִ��jar

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


3������ָ�� ������ mainClass  

<plugin>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-maven-plugin</artifactId>
     <version>1.4.2.RELEASE</version>
     <configuration>
         <mainClass>com.logicbig.example.MainClass</mainClass>
     </configuration>
</plugin>

4��@EnableAutoConfiguration   �����Ѿ����ص�jar �����Զ����� 



5�� @ComponentScan 

�� @ComponentScan  û��ָ����    ����ɨ�� ����@ComponentScan ���� ���ڵİ�


6��@SpringBootApplication ע����������������ע��  
@SpringBootConfiguration  
@EnableAutoConfiguration  
@ComponentScan  


7��ͨ�� SpringApplication ���� ��������  ������һЩ ��Ϊ

 		SpringApplication app = new SpringApplication(CustomBannerExample.class);
        app.setLogStartupInfo(false);

8���Զ����õ�ԭ��

   8.1  @Import     
                   ��Ӧ���У���ʱû�а�ĳ����ע�뵽IOC�����У��������õ�ʱ����Ҫ��ȡ�����Ӧ��bean����ʱ����Ҫ�õ�@Importע��  
                   
        @Import  Ҳ���Ե���һ��������             
             
   8.2   @EnableAutoConfiguration   @import ��   EnableAutoConfigurationImportSelector 
     
        EnableAutoConfigurationImportSelector ʵ����  DeferredImportSelector
         
        EnableAutoConfigurationImportSelector  ��ʹ�� pring core�� SpringFactoriesLoader.loadFactoryNames() 
         
                     ������  META-INF/spring.factories  �������õ��� 
                     
   8.3   The boot configuration classes ���   are loaded from spring-boot-autoconfigure-1.4.2.RELEASE.jar!/META-INF/spring.factories ������
   
                      ����spring.factories �ļ��� ���� key Ϊorg.springframework.boot.autoconfigure.EnableAutoConfiguration  ���õ���
                      
                      
  8.4     ������ 8.3 ���ص�һ��������    ʾ��
  
		 @Configuration
		 @ConditionalOnClass({ MBeanExporter.class })
		 @ConditionalOnProperty(prefix = "spring.jmx", name = "enabled", havingValue = "true", matchIfMissing = true)
		 public class JmxAutoConfiguration implements                    
		                      
                     ���� �����   @ConditionalOnClass         @ConditionalOnProperty   
                   
                              
       @ConditionalOnClass -- ����ĳ����ʱ   ��ע��     ��@ConditionalOnClassע��� ������
       
       @ConditionalOnProperty -- ����ĳЩ��������ʱ    ��ע�� ������
       
                   �����ص������� �������õ����������Ƿ� ע��
                   
 8.5    ��ֹĳ���Զ�����  :  
        @EnableAutoConfiguration(exclude = {JmxAutoConfiguration.class})                         
       
       
       













4��
















