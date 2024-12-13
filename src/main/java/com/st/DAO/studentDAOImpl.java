package com.st.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.API.Student;
import com.st.RowMapper.StudentRowMapper;

@Repository
public class studentDAOImpl implements StudentDAO {

	@Autowired

	private JdbcTemplate jdbctemplate;

	@Override
	public List<Student> loadStudents() {
		String sql = "SELECT * FROM students";

		List<Student> studentList = jdbctemplate.query(sql, new StudentRowMapper());

		return studentList;
	}

	@Override
	public List<Student> loadStudents(String deptName) {
		String sql = "SELECT * FROM students where deptName=?";

		List<Student> studentList = jdbctemplate.query(sql, new StudentRowMapper(), deptName);

		return studentList;
	}

	@Override
	public int saveStudent(Student student) {
		Object[] StudentArgs = { student.getName(), student.getMobile(), student.getCountry(), student.getDeptName() };

		String sql = "insert into students(name,mobile,country,deptName) values(?,?,?,?)";
		int inserted = jdbctemplate.update(sql, StudentArgs);
		return inserted;

	}

	@Override
	public Student getStudent(int userID) {
		String sql = "select *from students where id=?";
		Student student = jdbctemplate.queryForObject(sql, new StudentRowMapper(), userID);
		return student;
	}

	@Override
	public int updateStudentById(Student student) {
		String sql = "UPDATE students SET name = ?, mobile = ?, country = ?,deptName=? WHERE id = ?";

		int update = jdbctemplate.update(sql, student.getName(), student.getMobile(), student.getCountry(),
				student.getDeptName(), student.getId());

		return update;

	}

	@Override
	public int deleteStudentById(int userId) {

		String sql = "DELETE from students where id=?";
		int delete = jdbctemplate.update(sql, userId);
		return delete;

	}

}
