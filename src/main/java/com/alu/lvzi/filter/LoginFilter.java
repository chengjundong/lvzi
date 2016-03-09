package com.alu.lvzi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alu.lvzi.pojo.Admin;

/**
 * Servlet implementation class LoginFilter
 */
public class LoginFilter implements Filter
{
	public LoginFilter()
	{
		super();
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) 
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String loginURL = request.getContextPath()+"/admin/login";
		String vcodeURL = request.getContextPath()+"/admin/vcode";
		String doLoginURL = request.getContextPath()+"/admin/ajax/user_login";
		
		if(loginURL.equals(request.getRequestURI()) || vcodeURL.equals(request.getRequestURI())
			|| doLoginURL.equals(request.getRequestURI()))
		{
			chain.doFilter(request, response);
		}
		else
		{			
			Object user = request.getSession().getAttribute("user");
			if(null == user || !(user instanceof Admin))
			{
				response.sendRedirect(loginURL);
			}
			else
			{
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		
	}

	@Override
	public void destroy()
	{
		
	}

}
