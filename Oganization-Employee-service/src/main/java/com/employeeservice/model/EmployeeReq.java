package com.employeeservice.model;

/**
 * @author Haritha Nadimpall
 *
 */
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReq implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String empFirstName;

	@NotNull
	private String empLastName;

	@NotNull
	private String email;
}
