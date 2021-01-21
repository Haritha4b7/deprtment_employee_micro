package com.employeeservice.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class EmployeeRes {
	
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

	@NotNull
	private String empFirstName;

	@NotNull
	private String empLastName;

	@NotNull
	private String email;
}
