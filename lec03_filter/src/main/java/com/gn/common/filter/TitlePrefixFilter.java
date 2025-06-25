package com.gn.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import com.gn.common.wrapper.TitlePrefixWrapper;

/**
 * Servlet Filter implementation class TitlePrefixFilter
 */
@WebFilter("/board/write")
public class TitlePrefixFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public TitlePrefixFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// key가 title인 경우 원래 값 앞에 "[공지]" 문자열 추가
		
		// 이렇게까지 하면 완전 완벾!(instanceof 체킹 작업)
		if (request instanceof HttpServletRequest) {
			TitlePrefixWrapper wrappedRequest = new TitlePrefixWrapper((HttpServletRequest)request);
			chain.doFilter(wrappedRequest, response);			
		} else {
			chain.doFilter(request, response);						
		}		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
