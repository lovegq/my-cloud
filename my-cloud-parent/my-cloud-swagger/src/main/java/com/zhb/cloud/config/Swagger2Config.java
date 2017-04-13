package com.zhb.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Title: Swagger2Config.java
 * @Package com.zhb.kafka.config
 * @Description: Swagger2 的配置
 * @author zhb
 * @date 2017年3月17日 下午5:16:39
 * @version V1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.bootcwenao.feignserver.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Boot Swagger2 test Restful API").description("更多内容请详见代码")
				.termsOfServiceUrl("http://blog.csdn.net/cwenao").contact(new Contact("dfdsf", "dfdsd", "dfad"))
				.version("0.5.0").build();
	}

}
