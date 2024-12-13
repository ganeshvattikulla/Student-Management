package com.st.DAO;

import java.util.List;

import com.st.API.Student;

public interface StudentDAO {

	List<Student> loadStudents();

	List<Student> loadStudents(String deptName);

	int saveStudent(Student student);

	Student getStudent(int userID);

	int updateStudentById(Student student);

	int deleteStudentById(int userId);

}
