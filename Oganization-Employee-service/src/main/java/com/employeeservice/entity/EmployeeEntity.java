package com.employeeservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Haritha Nadimpalli
 *
 */
@Entity
@Table(name = "EMPLOYEE_INFO")

public class EmployeeEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empCode;

	public long getEmpCode() {
		return empCode;
	}

	public void setEmpCode(long empCode) {
		this.empCode = empCode;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String empFirstName;

	private String empLastName;

	private String email;

}
