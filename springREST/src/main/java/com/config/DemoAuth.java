package com.config;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class DemoAuth implements Authentication{

	private String userid;
	
	private List<SimpleGrantedAuthority> auth;
	
	public DemoAuth(String userid,List<SimpleGrantedAuthority> auth) {
		super();
		this.userid = userid;
		this.auth = auth;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return userid;
	}

	@Override
	public List<SimpleGrantedAuthority> getAuthorities() {
		return auth;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrincipal() {
		// TODO Auto-generated method stub
		return this.getName();
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

}
