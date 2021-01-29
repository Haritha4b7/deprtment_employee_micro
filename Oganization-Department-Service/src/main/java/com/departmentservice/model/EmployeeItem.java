package com.departmentservice.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeItem {

	@NotNull
	private long empCode;
	
	@NotNull
	private String empFirstName;

	@NotNull
	private String empLastName;

	@NotNull
	private String email;
}
