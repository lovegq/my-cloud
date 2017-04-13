package com.zhb.cloud.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Title: MybatisConfig.java
 * @Package com.zzh.sys.configuration
 * @Description: mybatis整合spring 核心配置
 * @author zhb
 * @date 2016年3月6日 下午7:56:12
 * @version V1.0
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {

	Logger log = LoggerFactory.getLogger(MyBatisConfig.class);
	@Autowired
	private DataSource dataSource;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		log.info("" + bean.getClass().getName());
		// 分页插件配置
		PageHelper pageHelper = new PageHelper();
		Properties prop = new Properties();
		// 该参数默认为false，设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用，和startPage中的pageNum效果一样
		// prop.setProperty("offsetAsPageNum", "true");

		// 3.3.0版本可用 - 分页参数合理化，默认false禁用
		// 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
		// 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据
		prop.setProperty("reasonable", "true");
		// 支持通过Mapper接口参数来传递分页参数
		prop.setProperty("supportMethodsArguments", "false");
		// always总是返回PageInfo类型,check检查返回类型是否为PageInfo,none返回Page
		prop.setProperty("returnPageInfo", "check");
		// 3.5.0版本可用 - 为了支持startPage(Object params)方法
		// 增加了一个`params`参数来配置参数映射，用于从Map或ServletRequest中取值
		// 可以配置pageNum,pageSize,count,pageSizeZero,reasonable,orderBy,不配置映射的用默认值
		// 不理解该含义的前提下，不要随便复制该配置
		// prop.setProperty("params", "count=countSql");
		pageHelper.setProperties(prop);
		bean.setPlugins(new Interceptor[] { pageHelper });
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources("classpath:com/zhb/cloud/mybatis/*/mapper/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public @Bean SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Override
	public @Bean PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
}
