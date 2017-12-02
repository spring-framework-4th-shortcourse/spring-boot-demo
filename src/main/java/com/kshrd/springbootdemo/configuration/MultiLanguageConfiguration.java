package com.kshrd.springbootdemo.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MultiLanguageConfiguration extends WebMvcConfigurerAdapter{
	
	//change default message location
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("i18n/messages");
		ms.setDefaultEncoding("utf-8");
		return ms;
	}
	
	//set default language
	@Bean 
	public LocaleResolver localeResolver(){
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(new Locale("en"));
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor(){
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
}
