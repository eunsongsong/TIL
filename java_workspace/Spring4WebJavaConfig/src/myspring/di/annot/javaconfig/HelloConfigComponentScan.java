package myspring.di.annot.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "myspring.di.annot" })
@PropertySource(value={"classpath:config/value.properties"})
public class HelloConfigComponentScan {
}
