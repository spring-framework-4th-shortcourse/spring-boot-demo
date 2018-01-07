package com.kshrd.springbootdemo.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()	
			.withUser("user").password("pwd").roles("USER").and()
			.withUser("dba").password("pwd").roles("DBA").and()
			.withUser("admin").password("pwd").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		
		//enable form login
		http.formLogin()
			//custom login page
			.loginPage("/login").permitAll();
		
		//logout
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/");
		
		//authorize url
		http.authorizeRequests()
			.antMatchers("/user/add").hasRole("ADMIN")
			.antMatchers("/user/edit**").hasRole("ADMIN")
			.anyRequest().authenticated();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		   .antMatchers("/assets/**")
		   .antMatchers("/webjars/**")
		   .antMatchers("/h2/**")
		  ;
	}
	
}
