package com.st.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.API.Admin;
import com.st.API.Student;
import com.st.DAO.AdminDAO;
import com.st.DAO.StudentDAO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO adminDAOImpl;
	@Autowired
	private StudentDAO studentDAOImpl;

	@Override
	public String saveAdmin(Admin admin) {
		String saveAdminData = adminDAOImpl.saveAdminData(admin);
		return saveAdminData;

	}

	@Override
	public Admin loginCheck(Admin admin) {
		
		return adminDAOImpl.loginCheck(admin);

	}

	@Override
	public List<Student> getSuperAdminDashboard() {
		List<Student> loadStudents = studentDAOImpl.loadStudents();
		return loadStudents;
		
	}

	@Override
	public void getDepartmentAdminDashboard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin getAdminByDeptName(String adminDeptName) {
		Admin adminBydeptName = adminDAOImpl.getAdminByDeptName(adminDeptName);
		return adminBydeptName;
	}

}
