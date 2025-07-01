package com.gn.service;

import java.util.List;

import com.gn.dao.StudentDao;
import com.gn.dto.Student;

public class StudentService {

	// DAO한테 부탁해서 데이터베이스에서 정보 조회, 들고, 수정, 삭제
	private StudentDao dao = new StudentDao();
	
	public List<Student> getStudentList() {
		List<Student> list = dao.selectAll();
		return list;
	}
	
	public Student getStudentDetail(int studentNo) {
		Student student = dao.selectOne(studentNo);
		return student;
	}
	
	public List<Student> getStudentNameList(String name) {
		List<Student> list = dao.selectNameAll(name);
		return list;
	}
	
	public int insertStudent(String name, int age) {
		// dao 에는 무조건 값을 하나밖에 못보냄 -> 그래서 담아줘야함
		// 1. map 에 담아 보내기: DTO에 없는 필드가 있을 경우, 혹은 보내줘야할 것이 3개 이하일 때 사용
		// 2. DTO 에 보내기: 기본적으로 이걸로 사용
		
		Student param = new Student();
		param.setStudentName(name);
		param.setStudentAge(age);
		
		return dao.insert(param);
	}
	
	public int updateStudent(int studentNo, String studentName, int studentAge ) {
		// dao 에는 무조건 값을 하나밖에 못보냄 -> 그래서 담아줘야함
		// 1. map 에 담아 보내기: DTO에 없는 필드가 있을 경우, 혹은 보내줘야할 것이 3개 이하일 때 사용
		// 2. DTO 에 보내기: 기본적으로 이걸로 사용
		Student student = new Student();
		student.setStudentNo(studentNo);
		student.setStudentName(studentName);
		student.setStudentAge(studentAge);
		
		return dao.update(student);
	}
}
