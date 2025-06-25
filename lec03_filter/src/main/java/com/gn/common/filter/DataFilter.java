package com.gn.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class DataFilter
 */
// @WebFilter(servletNames = "recieveDataServlet")
// @WebFilter(urlPatterns = "/*") // 이건 모든 url 요청에 대한 필터를 걸음
@WebFilter(urlPatterns = "/recieve/*") // 이건 recieve 로 url이 시작하는 모든 요청에 대한 필터를 걸음
public class DataFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public DataFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		// 필터가 소멸될 때 실행됨(보통 서버 내려갔을 때 죽음)
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요쳥과 응답을 처리하는 역할을 함(jsp -> dofilter -> servlet)
		
		// TODO Auto-generated method stub
		// place your code here
		// 1. 요청이 필터를 지나가전에 할 작업을 여기에 적어줌
		System.out.println("[DataFilter] 요청 가로챔");

		// pass the request along the filter chain
		// 2. 다음 필터나 서블릿으로 요청을 넘김
		chain.doFilter(request, response); // 요청과 응답을 가로막는 역할 = 즉 필터링 해주는 친구
		
		// 3. 서블릿의 작업이 끝나고 클라이언트로 가기전에 할 작업을 여기에 작성
		System.out.println("[DataFilter] 응답 가로챔");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터가 초기화될 깨 실행됨(초기화는 서버가 실행될 때)
		
		// TODO Auto-generated method stub
	}

}
