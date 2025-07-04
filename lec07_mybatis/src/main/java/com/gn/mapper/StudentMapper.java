package com.gn.mapper;

import java.util.List;

import com.gn.dto.Student;

public interface StudentMapper {
	
	List<Student> selectAll();
	
	Student selectOne(int studentNo);
	
	List<Student> selectNameAll();
	
	int insert(Student student);
	
	int updateStudent(Student student);
	
	int deleteStudent(Student student);
	
}
