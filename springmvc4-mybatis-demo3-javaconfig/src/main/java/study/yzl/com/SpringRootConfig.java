package study.yzl.com;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.aspectj.AnnotationTransactionAspect;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:/jdbc.properties")
@ComponentScan(value = "study.yzl.com",excludeFilters = {@Filter(type = FilterType.ANNOTATION,value = {org.springframework.stereotype.Controller.class})})
public class SpringRootConfig {
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	

    @Bean
	public org.mybatis.spring.mapper.MapperScannerConfigurer mapperScannerConfigurer() {

    	MapperScannerConfigurer msc= new MapperScannerConfigurer();
    	msc.setBasePackage("study.yzl.com.dao");
    	msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return msc;
	}
    
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
    
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource)  {
    	
    	return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean("cacheManager")
	// List<Cache>会主动搜索Cache的实现bean，并添加到caches中
	public SimpleCacheManager cacheManager(List<Cache> caches){
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		
		simpleCacheManager.setCaches(caches);
		return simpleCacheManager;
	}
    
    @Bean("springMapCache")
	public ConcurrentMapCacheFactoryBean springMapCache(){
		ConcurrentMapCacheFactoryBean stockDetail = new ConcurrentMapCacheFactoryBean();
		// 如果用户设置名称为stockDetail的缓存，则需要添加这样的一个bean
		stockDetail.setName("springMapCache");
		
		return stockDetail;
	}
    
    
	/*
	 * JDBC模板
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) throws SQLException {
		return new JdbcTemplate(druidDataSource);
	}
 
	@Bean
	public DataSourceTransactionManager txManager(DataSource dataSource) throws SQLException {
		
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource);
		AnnotationTransactionAspect.aspectOf().setTransactionManager(txManager);
		return txManager;
	}
 
	
	
	
	

}