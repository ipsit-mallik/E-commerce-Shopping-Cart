package com.jsp.shoppingcart.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class ConfigClass
{
	@Bean
	public InternalResourceViewResolver getResolver()
	{
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setSuffix(".jsp");
		irvr.setPrefix("/");
		return irvr;
	}
	
	@Bean
	public EntityManagerFactory getEmf()
	{
		return Persistence.createEntityManagerFactory("dev");
	}
}
