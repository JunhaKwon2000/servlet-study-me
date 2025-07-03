package com.gn.mapper;

import java.util.List;

import com.gn.dto.Member;

public interface MemberMapper {
	
	int insert(Member param);
	
	Member selectMember(Member param);
	
	List<Member> selectAll();

}
