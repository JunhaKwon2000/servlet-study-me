package com.gn.service;

import java.util.List;

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

	public Member selectMember(String memberId, String memberPw) {
		Member param = new Member();
		param.setMemberId(memberId);
		param.setMemberPw(memberPw);
		
		Member member = dao.selectMember(param);
		return member;
	}
	
	public List<Member> selectAll() {
		return dao.selectAll();
	}

}
