package com.st.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.API.Admin;
import com.st.API.Student;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String saveAdminData(Admin admin) {

		try {
			String sqlCheck = "SELECT COUNT(*) FROM studentmanagement.admins WHERE dept_name=?";
			int count = jdbcTemplate.queryForObject(sqlCheck, new Object[] { admin.getDeptName() }, Integer.class);
			if (count > 0) {
				if (admin.getDeptName().equals("NA")) {
					return "Prinicipal already existed !! please login 😄";
				} else {
					return "Admin with Deparment " + admin.getDeptName() + " already existed !!";
				}

			} else {
				String sql = "insert into studentmanagement.admins(admin_role,admin_name,admin_password,dept_name) values(?,?,?,?);";
				Object[] adminParms = { admin.getAdminRole(), admin.getAdminName(), admin.getAdminPassword(),
						admin.getDeptName() };
				int update = jdbcTemplate.update(sql, adminParms);
				if (update > 0) {
					return "Admin data saved successfully, please Login !!";
				}

			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}

		return "Error occured while saving data, Try again 😶😶";
	}

	@Override
	public List<Student> loadStudents() {

		return null;
	}

	@Override
	public Admin loginCheck(Admin admin) {

		String sql = "SELECT * FROM studentmanagement.admins WHERE admin_name=? AND admin_role=?";
		System.out.println(admin);
		try {
//			String storedPassword = jdbcTemplate.queryForObject(sql, String.class, admin.getAdminName(),
//					admin.getAdminRole());
//			System.out.println(storedPassword+"hi");
			List<Admin> Admins = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Admin.class), admin.getAdminName(),
					admin.getAdminRole());
			for (Admin temp : Admins) {
				System.out.println(temp);
				if (temp.getAdminPassword().equals(admin.getAdminPassword())) {
					return temp;
				}

			}

		} catch (DataAccessException e) {
			e.getMessage();
			return null;
		}
		return null;

	}

	@Override
	public Admin getAdminByDeptName(String adminDeptName) {
		String sql = "select * from studentmanagement.admins where dept_name=?";
		Admin admin = jdbcTemplate.queryForObject(sql, new Object[] { adminDeptName },
				new BeanPropertyRowMapper<>(Admin.class));

		return admin;
	}

}
