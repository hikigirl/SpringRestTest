package com.test.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//스프링 설정 방식
// 1. XML
// 2. Annotation
// 3. Java 방식 -> 지금 해볼거임(Swagger 세팅)

@Configuration @EnableSwagger2
public class SwaggerConfig {
	//스프링 빈 만들기
	// REST API 명세를 만들기 위한 설정 -> 도움말 설정
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(getApiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.test.rest"))
					.paths(PathSelectors.any())
					.build();
	}
	
	//문서 제목, 버전, 설명 등...
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Address Rest API")
				.version("0.0.1")
				.description("Address 데이터에 대한 REST API 명세서입니다.")
				.build();
	}
	
}
