package com.manit.ems.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.manit.ems.auth.MyUserDetails;
import com.manit.ems.service.MyUserDetailsService;
import com.manit.ems.util.JwtUtil;

import io.jsonwebtoken.Claims;

@Component
public class JwtRequest extends OncePerRequestFilter {
	
	@Autowired
	private MyUserDetailsService myUserdetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String userName = null;
		String jwt = null;
		String authHeader = request.getHeader("Authentication");
		
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			jwt = authHeader.substring(7);
			userName = jwtUtil.extractUsername(jwt);
		}
		
		if(userName !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			String role;
			Claims claims = jwtUtil.extractAllClaims(jwt);
			role=(String) claims.get("role");
			request.setAttribute("role",role);
			MyUserDetails myUserDetails = myUserdetailsService.loadUserByUsername(userName);
			System.out.println("----->"+myUserDetails);
			if(jwtUtil.validateToken(jwt, myUserDetails)) {
				UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = 
						new UsernamePasswordAuthenticationToken(myUserDetails, null, myUserDetails.getAuthorities());
				userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
				request.setAttribute("id",myUserDetails.getId());
			}
		}
		filterChain.doFilter(request,response);
	}

}
