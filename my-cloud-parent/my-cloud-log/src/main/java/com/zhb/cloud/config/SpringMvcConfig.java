package com.zhb.cloud.config;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zhb.cloud.core.interceptor.LoginInterceptor;

@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
	private final static Logger logger = LoggerFactory.getLogger(SpringMvcConfig.class);

	/**
	 * 添加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("添加登陆拦截器{}", "LoginInterceptor");
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index**",
				"/register**", "/login**");
		super.addInterceptors(registry);
	}

	/**
	 * 消息转换器
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN));
		converters.add(jackson2HttpMessageConverter);
		super.configureMessageConverters(converters);
	}
}
