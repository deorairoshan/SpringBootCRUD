package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.Employee;
import com.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//@RequestMapping("/test")
	@GetMapping(value="/test")
	public String test(){
		return "Test success..";
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return employeeService.getAll();
	}
	
	@GetMapping("/get")
	public Employee getEmployee(@RequestParam int id){
		return employeeService.get(id);
	}
	
	@PostMapping("/save")
	public void insertEmployee(@RequestBody Employee employee){
		employeeService.save(employee);
	}
	
	@PostMapping("/update")
	public void updateEmployee(@RequestBody Employee employee){
		employeeService.update(employee);
	}
	
	@PostMapping("/delete")
	public void deleteEmployee(@RequestBody int id){
		employeeService.delete(id);
	}

}
