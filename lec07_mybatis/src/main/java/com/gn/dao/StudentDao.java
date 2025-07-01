package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Student;

public class StudentDao {
	
	public List<Student> selectAll() {
		// DB 접근(마이바티스)
		SqlSession session = SessionTemplate.getSqlSession(true);
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.selectAll");
		session.close();
		return list;
	}
	
	public Student selectOne(int studentNo) {
		// DB 접근(마이바티스)
		SqlSession session = SessionTemplate.getSqlSession(true);
		Student student = session.selectOne("com.gn.mapper.StudentMapper.selectOne", studentNo);
		session.close();
		return student;
	}
	
	public List<Student> selectNameAll(String name) {
		// DB 접근(마이바티스)
		SqlSession session = SessionTemplate.getSqlSession(true);
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.selectNameAll", name);
		session.close();
		return list;
	}
	
	public int insert(Student param) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.StudentMapper.insert", param);
		session.close();
		return result;
	}
	
	// 전달받은 정보로 update하고 싶어요
	public int update(Student student) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.StudentMapper.updateStudent", student);
		session.close();
		return result;
	}

}
