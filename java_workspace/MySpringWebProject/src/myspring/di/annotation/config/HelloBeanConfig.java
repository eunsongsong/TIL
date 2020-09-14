package myspring.di.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
	<!-- Properties file ���� ���� -->
	<context:property-placeholder
		location="classpath:config/values.properties" />

	<!-- Component Auto Scanning�� ���� ���� -->
	<context:component-scan
		base-package="myspring.di.annotation" />
 */

@Configuration
@PropertySource("classpath:config/values.properties")
@ComponentScan(basePackages = {"myspring.di.annotation"})
public class HelloBeanConfig {
	
}
