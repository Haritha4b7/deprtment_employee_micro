package com.departmentservice.model;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Haritha
 *
 */

public class DepartmentReq {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min = 2, message = "Name should be atlease 2 characters ")
	private String departmentName;

	@NotNull
	private String deptHead;

	@NotNull
	public Set<Long> empIds;

	@NotNull
	private String departmentDes;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	public Set<Long> getEmpIds() {
		return empIds;
	}

	public void setEmpIds(Set<Long> empIds) {
		this.empIds = empIds;
	}

	public String getDepartmentDes() {
		return departmentDes;
	}

	public void setDepartmentDes(String departmentDes) {
		this.departmentDes = departmentDes;
	}
	
}
