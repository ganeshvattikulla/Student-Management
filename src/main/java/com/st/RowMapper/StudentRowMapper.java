package com.st.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.API.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int arg1) throws SQLException {
		Student st = new Student();

		st.setId(rs.getInt("id"));
		st.setName(rs.getString("name").toUpperCase());
		st.setMobile(rs.getLong("mobile"));
		st.setCountry(rs.getString("country").toUpperCase());
		st.setDeptName(rs.getString("deptName").toUpperCase());

		return st;
	}

}
