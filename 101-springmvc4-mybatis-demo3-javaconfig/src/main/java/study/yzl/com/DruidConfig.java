package study.yzl.com;

 
import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.SQLException;

import javax.sql.DataSource;
 
/**
 * Created by Administrator on 2018/8/20 0020.
 * Druid 数据源配置类
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DruidConfig {
 
    /**
     * 将自定义的 Druid 数据源添加到容器中，不再让 Spring Boot 自动创建
     * 这样做的目的是：绑定全局配置文件中的 druid 数据源属性到 com.alibaba.druid.pool.DruidDataSource
     * 从而让它们生效
     * @ConfigurationProperties(prefix = "spring.datasource")：作用就是将 全局配置文件中 前缀为 spring.datasource
     * 的属性值注入到 com.alibaba.druid.pool.DruidDataSource 的同名参数中
     *
     * @return
     */
	
	
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	
	
	
	
	@Bean
	public DruidDataSource dataSource()  throws SQLException {
		
		System.out.println("================================================="+url);
		System.out.println("================================================="+username);
		System.out.println("================================================="+password);
		
		
		DruidDataSource ds = new DruidDataSource();
		/*
		 * 基本属性
		 */
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		/*
		 * 配置初始化大小、最小、最
		 */
		ds.setInitialSize(1);
		ds.setMinIdle(1);
		ds.setMaxActive(10);
		/*
		 * 配置获取连接等待超时的时间
		 */
		ds.setMaxWait(60000);
		/*
		 * 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		 */
		ds.setTimeBetweenEvictionRunsMillis(60000);
		/*
		 * 配置一个连接在池中最小生存的时间，单位是毫秒
		 */
		ds.setMinEvictableIdleTimeMillis(300000);

		ds.setValidationQuery("SELECT 'X'");
		ds.setTestWhileIdle(true);
		ds.setTestOnBorrow(false);
		ds.setTestOnReturn(false);

		/*
		 * 打开PSCache，并且指定每个连接上PSCache的大小
		 */
		ds.setPoolPreparedStatements(false);
		;
		ds.setMaxPoolPreparedStatementPerConnectionSize(20);
		/*
		 * 配置监控统计拦截的filters
		 */
		ds.setFilters("stat");

		return ds;

	}
	
}
