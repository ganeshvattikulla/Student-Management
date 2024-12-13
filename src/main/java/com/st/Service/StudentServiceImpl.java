package com.st.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.API.Student;
import com.st.DAO.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAOImpl;

	@Override
	public List<Student> loadStudents() {
		// TODO Auto-generated method stub
		List<Student> loadStudents = studentDAOImpl.loadStudents();
		return loadStudents;
	}
	@Override
	public List<Student> loadStudents(String deptName) {
		List<Student> loadStudents = studentDAOImpl.loadStudents(deptName);
		return loadStudents;
	}

	@Override
	public int saveStudent(Student student) {
		int saveStudent = studentDAOImpl.saveStudent(student);
		return saveStudent;
	}

	@Override
	public Student getStudent(int userID) {
		Student loadStudent = studentDAOImpl.getStudent(userID);
		return loadStudent;
	}

	@Override
	public int updateStudentById(Student student) {
		int updateStudentById = studentDAOImpl.updateStudentById(student);
		return updateStudentById;
	}

	@Override
	public int deleteStudentById(int userId) {

		int deleteStudentById = studentDAOImpl.deleteStudentById(userId);
		
		
		return deleteStudentById;
		
	}

	

	
}
