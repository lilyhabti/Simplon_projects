package com.example.gestion.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.gestion.model.Admin;
import com.example.gestion.model.Employee;
import com.example.gestion.service.AdminService;
import com.example.gestion.service.GestionService;

@Controller
public class MainController {

	@Autowired
	private GestionService employeeService;

	@Autowired
	private AdminService adminService;

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("admin", new Admin());
		return mav;
	}

	@PostMapping("/")
	public String login(@ModelAttribute("admin") Admin admin) {

		Admin oauthAdmin = adminService.login(admin.getUsername(), admin.getPassword());

		System.out.print(oauthAdmin);

		if (Objects.nonNull(oauthAdmin)) {

			return "redirect:/home";

		} else {
			return "redirect:/";

		}

	}

	@GetMapping("/logout")
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/";
	}

	// display list of employees
	@GetMapping("/home")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee
		employeeService.saveEmployee(employee);
		return "redirect:/home";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Employee employee = employeeService.getEmployeeById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/home";
	}
}
