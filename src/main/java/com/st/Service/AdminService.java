package com.st.Service;

import java.util.List;

import com.st.API.Admin;
import com.st.API.Student;

public interface AdminService {

	String saveAdmin(Admin admin);

	Admin loginCheck(Admin admin);

	List<Student> getSuperAdminDashboard();

	void getDepartmentAdminDashboard();

	Admin getAdminByDeptName(String adminDeptName);

}
