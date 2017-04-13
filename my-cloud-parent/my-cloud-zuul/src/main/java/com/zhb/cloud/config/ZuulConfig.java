package com.zhb.cloud.config;

import org.springframework.context.annotation.Bean;

import com.zhb.cloud.core.filter.AccessFilter;
import com.zhb.cloud.core.filter.ErrorFilter;
import com.zhb.cloud.core.filter.PostFilter;
import com.zhb.cloud.core.filter.RouteFilter;

/**
 * @Title: ZuulConfig.java
 * @Package com.zhb.cloud.config
 * @Description: ZuulConfig 核心配置文件
 * @author zhb
 * @date 2016年12月20日 上午10:25:30
 * @version V1.0
 */
public class ZuulConfig {
	/**
	 * @Title: accessFielter
	 * @Description:访问过滤
	 * @return AccessFilter
	 * @author: zhb
	 * @throws 2016年12月20日下午2:28:55
	 */
	public @Bean AccessFilter accessFielter() {
		return new AccessFilter();
	}

	/**
	 * @Title: routeFilter
	 * @Description: 路由转发
	 * @return AccessFilter
	 * @author: zhb
	 * @throws 2016年12月20日下午2:29:14
	 */
	public @Bean RouteFilter routeFilter() {
		return new RouteFilter();
	}

	/**
	 * @Title: postFilter
	 * @Description: 相应处理
	 * @return PostFilter
	 * @author: zhb
	 * @throws 2016年12月20日下午2:30:43
	 */
	public @Bean PostFilter postFilter() {
		return new PostFilter();
	}

	/**
	 * @Title: errorFilter
	 * @Description: 错误处理
	 * @return ErrorFilter
	 * @author: zhb
	 * @throws 2016年12月20日下午2:31:35
	 */
	public @Bean ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
}
