package com.demo.service;

import java.util.List;

import com.demo.models.Employee;

public interface EmployeeService {

	public List<Employee> getAll();

	public Employee get(int id);

	public void save(Employee employee);

	public void update(Employee employee);

	public void delete(int id);
}
