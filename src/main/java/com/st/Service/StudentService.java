package com.st.Service;

import java.util.List;

import com.st.API.Student;

public interface StudentService {
	List<Student> loadStudents();

	List<Student> loadStudents(String deptName);

	int saveStudent(Student student);

	Student getStudent(int userID);

	int updateStudentById(Student student);

	int deleteStudentById(int userId);

}
