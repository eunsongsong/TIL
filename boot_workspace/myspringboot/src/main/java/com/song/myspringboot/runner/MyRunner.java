package com.song.myspringboot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.song.myspringboot.property.SongProperties;

@Component
@Order(2)
public class MyRunner implements ApplicationRunner{
	@Value("${song.name}")
	String name;
		
	@Autowired
	private SongProperties property;
	
	@Autowired
	private String hello;
	
	private Logger logger = LoggerFactory.getLogger(MyRunner.class);
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("===>>> start  Info Mode에서만 출력됩니다.");
		logger.debug("Profile : " + hello);
		logger.debug("Logger 클래스 이름 : " + logger.getClass().getName());
		logger.debug("song.name : " + name);
		logger.debug("song.age : " + property.getAge());
		logger.debug("song.fullName : " + property.getFullName());
		logger.info("===>>> end  Info Mode에서만 출력됩니다.");
	}

}
