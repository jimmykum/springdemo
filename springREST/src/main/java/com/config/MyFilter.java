package com.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class MyFilter extends OncePerRequestFilter {

	 @Override
	    protected void doFilterInternal(HttpServletRequest request,
	            HttpServletResponse response, FilterChain filterChain)
	            throws ServletException, IOException {
	        
	        String xAuth = request.getHeader("X-Authorization");
	        
	      System.out.println("*********filter " + xAuth);  
	        // The token is 'valid' so magically get a user id from it
	        if (xAuth != null){
	      List<SimpleGrantedAuthority> al = 	new ArrayList<>();
	        al.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	        // Create our Authentication and let Spring know about it
	        Authentication auth = new DemoAuth(xAuth,al);
	        SecurityContextHolder.getContext().setAuthentication(auth);            
	        } 
	        filterChain.doFilter(request, response);
	    }
}
