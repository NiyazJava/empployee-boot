package com.springboot.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.entity.Employee;

public interface EmployeeJapRepository extends JpaRepository<Employee,Integer> {

}
