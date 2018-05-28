package com.springboot.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
@Entity
@Table(name="employe_Tab")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "EMP_ID")
	private Integer empid;
    @Column(name = "EMP_NAME")
	private String empName;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/YYYY")
	private Date dateOFJoining;
    @Column(name = "EMP_CONTACT",nullable=false)
	private String empContact;
    @Column(name = "EMP_ADDRESS")
	private String empAddress;
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getDateOFJoining() {
		return dateOFJoining;
	}
	public void setDateOFJoining(Date dateOFJoining) {
		this.dateOFJoining = dateOFJoining;
	}
	public String getEmpContact() {
		return empContact;
	}
	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer empid, String empName, Date dateOFJoining, String empContact, String empAddress) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.dateOFJoining = dateOFJoining;
		this.empContact = empContact;
		this.empAddress = empAddress;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", dateOFJoining=" + dateOFJoining
				+ ", empContact=" + empContact + ", empAddress=" + empAddress + "]";
	}
	
	
}
