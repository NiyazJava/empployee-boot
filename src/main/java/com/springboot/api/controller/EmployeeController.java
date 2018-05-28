package com.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.entity.Employee;
import com.springboot.api.exception.handler.EmployeeApplicationException;
import com.springboot.api.services.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
	private EmployeeService service;
	@PostMapping(value="/employee",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		employee=service.saveEmployee(employee);
		if(employee==null||employee.getEmpid()==null){
             throw new EmployeeApplicationException("Employee Not saved","Emp-404");
		}
		return new ResponseEntity<>(employee,HttpStatus.CREATED);
	}
	@GetMapping(value="/employee",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Employee>> listOfAllEmployee(Pageable pageable){
		Page<Employee>employeeObj=service.getAllEmployee(pageable);
		if(employeeObj==null){
			throw new EmployeeApplicationException("Employee Not found","Emp-404");
		}
		return new ResponseEntity<>(employeeObj,HttpStatus.FOUND);
	}
	@GetMapping(value="/employee/{empId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getOneEmployeeObjectById(@PathVariable("empId")Integer empId){
		Employee employee=service.getEmployeeById(empId);
		if(employee==null){
			throw new EmployeeApplicationException("Employee Not found","Emp-404");
		}
		return new ResponseEntity<Employee>(employee,HttpStatus.FOUND);
	}
	@PutMapping(value="/employee{empid}")
	public ResponseEntity<Void> updateEmployeeByid(@PathVariable("empId") Integer empId,@RequestBody Employee employee){
		service.updateEmployee(empId, employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	public ResponseEntity<Void> removeEmployeeById(@PathVariable("empId")Integer empId){
		service.deleteEmployee(empId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
