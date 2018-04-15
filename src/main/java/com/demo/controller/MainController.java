package com.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Employee;
import com.demo.service.EmployeeService;

@Controller
public class MainController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String init(HttpServletRequest request) {
		request.setAttribute("employees", employeeService.getAll());
		request.setAttribute("mode", "EMPLOYEE_VIEW");
		return "index";
	}

	@GetMapping("/editEmployee")
	public String editEmployee(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("employee", employeeService.get(id));
		request.setAttribute("mode", "EMPLOYEE_EDIT");
		return "index";
	}

	@GetMapping("/newEmployee")
	public String newEmployee(HttpServletRequest request) {
		request.setAttribute("employee", new Employee());
		request.setAttribute("mode", "EMPLOYEE_NEW");
		return "index";
	}

	@PostMapping("/save")
	public void update(@ModelAttribute Employee employee, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		if (employee.getId() == 0)
			employeeService.save(employee);
		else
			employeeService.update(employee);
		request.setAttribute("employees", employeeService.getAll());
		request.setAttribute("mode", "EMPLOYEE_VIEW");
		response.sendRedirect("/");
	}
	
	@GetMapping("/deleteEmployee")
	public void deleteEmployee(@RequestParam int id, HttpServletRequest request,HttpServletResponse response) throws IOException {
		employeeService.delete(id);
		request.setAttribute("employees", employeeService.getAll());
		request.setAttribute("mode", "EMPLOYEE_VIEW");
		response.sendRedirect("/");
	}

}
