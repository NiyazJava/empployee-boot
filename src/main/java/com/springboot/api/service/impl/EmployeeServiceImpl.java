package com.springboot.api.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.api.dao.EmployeeJapRepository;
import com.springboot.api.entity.Employee;
import com.springboot.api.services.EmployeeService;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
   
	@Autowired
	private EmployeeJapRepository repository;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Override
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Page<Employee> getAllEmployee(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		return fetchIfExist(empId);
	}

	@Override
	public void updateEmployee(Integer empId,Employee employee) {
		Employee employees=fetchIfExist(empId);
		BeanUtils.copyProperties(employee, employees,"empld");

	}

	@Override
	public void deleteEmployee(Integer empId) {
		Employee employee=fetchIfExist(empId);
		repository.delete(employee);

	}
	private Employee fetchIfExist(Integer empId){
	 Employee employee=repository.getOne(empId);
	 if(employee ==null){
		 throw new RuntimeException("Employee Not Find");
	 }
	 return employee;
	}

}
