package com.song.myspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 해당 url 패턴을 매칭
		registry.addResourceHandler("/mobile/**") // url 등록
		// 반드시 m 다음에 / 을 주어야 한다.
		.addResourceLocations("classpath:/mobile/") // 리소스 위치
		.setCachePeriod(20);//20초
	}

	
}
