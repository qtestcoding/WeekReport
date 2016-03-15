/**
 * @package com.com
 * @author cuiyueyang
 * @date 2016-3-10 下午6:05:12
 * @todo TODO
 */
package com.com;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author cuiyueyang
 * @data 2016-3-10 下午6:05:12
 * @todo TODO
 */
public class SessionFilter extends OncePerRequestFilter{

	/* (non-Javadoc)
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] nofilter = {"/login.html","/login-success.html","/login-out.html","/global-error-404.html"};
		String uri = request.getRequestURI();
		boolean doFilter = true;
		for(String str:nofilter){
			if(uri.indexOf(str) != -1){
				doFilter = false;
				break;
			}
		}
		if(doFilter){
			String username = (String) request.getSession().getAttribute("username");
			if(null == username || "".equals(username)){
				request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                request.getRequestDispatcher("/login.html").forward(request,response);
			}else{
				filterChain.doFilter(request, response);
			}
		}else{
			filterChain.doFilter(request, response);
		}
	}
}
