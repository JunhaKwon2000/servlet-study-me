package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AnonymousWrapper extends HttpServletRequestWrapper {

	public AnonymousWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getParameter(String name) {
		String value =  super.getParameter(name);
		
		if (name.equals("writer")) {
			if (value.trim().equals("") || !(value.equals("익명")) || value == null) {
				return "익명";
			}
		}
		
		return value;
	}
	
}
