package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dto.Member;

public class MemberDao {
	
	public int insert(Member param) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.MemberMapper.insert", param);
		session.close();
		return result;
	}

	public Member selectMember(Member param) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		Member member = session.selectOne("com.gn.mapper.MemberMapper.selectMember", param);
		session.close();
		return member;
	}
	
	public List<Member> selectAll() {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		List<Member> list = session.selectList("com.gn.mapper.MemberMapper.selectAll");
		session.close();
		return list;
	}
	
	

}
