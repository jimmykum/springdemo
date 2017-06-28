package com.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class DemoAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		DemoAuth auth = (DemoAuth)authentication ;
		if (auth.getPrincipal() == null){
			System.out.println("************* no");
		return null;
		} else {
			System.out.println("************* yes"+auth.getPrincipal());
			return authentication;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
