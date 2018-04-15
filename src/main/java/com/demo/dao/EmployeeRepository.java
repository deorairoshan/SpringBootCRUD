package com.demo.dao;

import java.util.List;

import com.demo.models.Employee;

public interface EmployeeRepository {

	public List<Employee> getAll();

	public Employee get(int id);

	public void save(Employee employee);

	public void update(Employee employee);

	public void delete(int id);
}
