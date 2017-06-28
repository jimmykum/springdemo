package com.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.rest.HelloWorldService;

@Component
public class JerseyConfig extends ResourceConfig {

	 public JerseyConfig() {
	        registerEndpoints();
	    }

	    private void registerEndpoints() {
	      this.register(HelloWorldService.class);
	    }
}
