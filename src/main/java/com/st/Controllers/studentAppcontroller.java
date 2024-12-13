package com.st.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.st.API.Admin;
import com.st.API.Student;
import com.st.Service.AdminService;
import com.st.Service.StudentService;

@Controller
public class studentAppcontroller {

	@Autowired
	private StudentService studentServiceImpl;
	@Autowired
	private AdminService adminServiceImpl;

	@GetMapping("/showStudent")
	public String showStudentList(@RequestParam("adminDeptName") String adminDeptName, Model model) {

		Admin admin = adminServiceImpl.getAdminByDeptName(adminDeptName);
		model.addAttribute("adminName", admin.getAdminName());
		model.addAttribute("adminDeptName", admin.getDeptName());

		if ("Super_Admin".equals(admin.getAdminRole())) {
			List<Student> loadStudents = studentServiceImpl.loadStudents();
			model.addAttribute("students", loadStudents);

		} else if ("Dept_Admin".equals(admin.getAdminRole())) {
			List<Student> loadStudents = studentServiceImpl.loadStudents(admin.getDeptName());
			model.addAttribute("students", loadStudents);

		} else {
			// handinling unexcepted roles
		}

		return "student-list";

	}

	@GetMapping("/showAddStudentPage")
	public String addStudent(@ModelAttribute("student") Student student, 
	                         @RequestParam("adminDeptName") String adminDeptName, 
	                         Model model) {
	    model.addAttribute("adminDeptName", adminDeptName);
	    return "add-student";
	}


	@PostMapping("/save-student")
	public String saveStudent(Student student, @RequestParam("adminDeptName") String adminDeptName) {
		int studentId = student.getId();
		if (studentId == 0) {
			// save

			int saveStudent = studentServiceImpl.saveStudent(student);
			if (saveStudent > 0) {
				System.out.println("student data inserted");

			}
		} else {
			// saveupdate

			int updateStudentById = studentServiceImpl.updateStudentById(student);
			if (updateStudentById > 0) {
				System.out.println("student data updated");

			}

		}

		return "redirect:/showStudent?adminDeptName=" + adminDeptName;

	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userID") int userID, @RequestParam("adminDeptName") String adminDeptName,
			Model model) {

		Student TheStudent = studentServiceImpl.getStudent(userID);
		model.addAttribute("student", TheStudent);
		model.addAttribute("adminDeptName", adminDeptName);
		return "add-student";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userID") int userID, @RequestParam("adminDeptName") String adminDeptName,
			Model model) {
	    int deleteStudentById = studentServiceImpl.deleteStudentById(userID);
	    if (deleteStudentById > 0) {
	        System.out.println("student data deleted");
	    }
	    return "redirect:/showStudent?adminDeptName=" + adminDeptName;
	}


}
