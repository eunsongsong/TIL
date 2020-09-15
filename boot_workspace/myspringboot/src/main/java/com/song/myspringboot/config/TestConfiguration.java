package com.song.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfiguration {
	
	@Bean
	public String hello() {
		return "현재는 테스트 Mode입니다.";
	}
	
}
