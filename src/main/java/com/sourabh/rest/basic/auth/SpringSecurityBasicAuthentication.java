package com.sourabh.rest.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityBasicAuthentication extends WebSecurityConfigurerAdapter{

	
	/**
	 * Override this method to configure the {@link HttpSecurity}. Typically subclasses
	 * should not invoke this method by calling super as it may override their
	 * configuration. The default configuration is:
	 *
	 * <pre>
	 * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	 * </pre>
	 *
	 * @param http the {@link HttpSecurity} to modify
	 * @throws Exception if an error occurs
	 */
	// @formatter:off
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.anyRequest().authenticated()
				.and()
			//.formLogin().and()
			.httpBasic();
	}
}
