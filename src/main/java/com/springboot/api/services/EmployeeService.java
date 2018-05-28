package com.springboot.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.api.entity.Employee;

public interface EmployeeService {
  
	public Employee saveEmployee(Employee employee);
	public Page<Employee> getAllEmployee(Pageable pageable);
	public Employee getEmployeeById(Integer empId);
	public void updateEmployee(Integer empId,Employee employee);
	public void deleteEmployee(Integer empId);
	
}
