package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.config.DemoAuthenticationProvider;
import com.config.MyFilter;
import com.config.RestAuthenticationEntryPoint;

@SpringBootApplication
@EnableWebSecurity
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan("com")
@Order(value=1)
public class SpringRestApplication extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
    private DemoAuthenticationProvider demoAuthenticationProvider;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

	   @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {        
	        auth.authenticationProvider(demoAuthenticationProvider);        
	    }  

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	  
		
		http
		.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
		.and()
		.authorizeRequests().antMatchers("/api/foos/hello/*").fullyAuthenticated().and()
		.addFilterAfter(new MyFilter(),BasicAuthenticationFilter.class);
		
		
		
		/* http.authorizeRequests()
	        .antMatchers("/api/foos/hello/*").access("hasRole('USER')").and()
	        .formLogin().and()
	        .addFilterBefore(new MyFilter(), BasicAuthenticationFilter.class) ;*/
	      //  
	       
		
		/* http.authorizeRequests().anyRequest().fullyAuthenticated().and().
		    
		    csrf().disable();
		*/
		
		
		
	}
}
