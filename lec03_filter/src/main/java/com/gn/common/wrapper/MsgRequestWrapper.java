package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class MsgRequestWrapper extends HttpServletRequestWrapper{

	public MsgRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	
	// getParameter -> 우리 맨날 쓰는거 이걸 재정의할거임 어떻게? 욕설을 필터링하는 기능을 추가해성 욕설이 필터링된 단어를 뱉도록
	@Override
	public String getParameter(String name) {
		// 원래 코드
		// return super.getParameter(name);
		
		String value = super.getParameter(name);
		if (name.equals("msg") && value != null) {
			return value.replaceAll("shit", "***");
		}
		return value;
	}
	
	
}
