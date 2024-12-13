package com.st.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.st.API.Admin;
import com.st.API.Student;
import com.st.Service.AdminService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminServiceImpl;

	@GetMapping("/adminLoginPage")
	public String showLoginPage(@ModelAttribute("admin") Admin admin) {
		return "AdminLogin";
	}

	@GetMapping("/adminSignupPage")
	public String showSignUpPage(@ModelAttribute("admin") Admin admin) {
		return "AdminSignup";
	}

	@PostMapping("/adminSignUp")
	public String adminsignUp(@ModelAttribute("admin") Admin admin, Model model) {

		String saveAdmin = adminServiceImpl.saveAdmin(admin);

		if (saveAdmin != null) {
			System.out.println("Message being passed: " + saveAdmin);
			model.addAttribute("message", saveAdmin); // Add message to model
			return "AdminSignup";
		}
		return "redirect:/adminSignupPage"; // Redirect only if the operation fails
	}

	@GetMapping("/adminLogin")
	public String adminLogin(@ModelAttribute("admin") Admin admin, Model model) {
		Admin result = adminServiceImpl.loginCheck(admin);
		if (result != null) {
			model.addAttribute("message", "Login Success!");
			return "redirect:/showStudent?adminDeptName=" + result.getDeptName();

		} else {

			model.addAttribute("message", "Invalid credentials ,Please try again!!");
		}

		return "AdminLogin";

	}

	@GetMapping("superAdminDashboard")
	public String superAdminDashboard(@ModelAttribute("students") Student student, Model model) {
		return "superDashboard";
	}

}
