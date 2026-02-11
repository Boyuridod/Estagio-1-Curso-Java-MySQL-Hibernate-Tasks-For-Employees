package br.com.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/employee")
//public class AuthenticateFilter implements Filter {
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		System.out.println("Logging request for: " + httpRequest.getRequestURL());
//		
//		chain.doFilter(request, response);
//		
//		System.out.println("Finished processing request for: " + httpRequest.getRequestURL());
//	}
//
//}
