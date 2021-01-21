package com.departmentservice.entity;

import java.util.Set;

import javax.persistence.ElementCollection;
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
 * @author Haritha Nadipalli
 *
 */
@Entity
@Table(name = "DEPT_DATA")

public class DepartmentEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deptId;

	private String departmentName;

	private String deptHead;

	@ElementCollection(targetClass = Long.class)
	public Set<Long> empIds;
	
	private String departmentDes;

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

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
