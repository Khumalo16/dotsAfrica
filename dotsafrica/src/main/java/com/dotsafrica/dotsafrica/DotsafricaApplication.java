package com.dotsafrica.dotsafrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;


@SpringBootApplication
public class DotsafricaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DotsafricaApplication.class, args);
	}

	// @Primary
	// @Bean
	// public FreeMarkerConfigurationFactoryBean factoryBean() {
	//   FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
	//   bean.setTemplateLoaderPath("classpath:/templates");
	//   return bean;
	  
	// }

}
