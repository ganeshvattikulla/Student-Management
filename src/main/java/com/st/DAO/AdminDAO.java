package com.st.DAO;

import java.util.List;

import com.st.API.Admin;
import com.st.API.Student;

public interface AdminDAO {

	String saveAdminData(Admin admin);

	List<Student> loadStudents();
	
	Admin loginCheck(Admin admin);

	Admin getAdminByDeptName(String adminDeptName);

	

}
