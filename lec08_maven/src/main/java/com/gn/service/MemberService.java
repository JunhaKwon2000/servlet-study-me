package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	
	private MemberDao dao = new MemberDao(); 

	public int insertMember(String id, String pw) {
		Member param = new Member();
		param.setMemberId(id);
		param.setMemberPw(pw);
		return dao.insert(param);
	}
	
//	public int insertStudent(String name, int age) {
//		// dao 에는 무조건 값을 하나밖에 못보냄 -> 그래서 담아줘야함
//		// 1. map 에 담아 보내기: DTO에 없는 필드가 있을 경우, 혹은 보내줘야할 것이 3개 이하일 때 사용
//		// 2. DTO 에 보내기: 기본적으로 이걸로 사용
//		
//		Student param = new Student();
//		param.setStudentName(name);
//		param.setStudentAge(age);
//		
//		return dao.insert(param);
//	}

}
