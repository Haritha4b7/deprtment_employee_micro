package com.departmentservice.service;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.departmentservice.model.EmployeeItem;

/**
 * @author Haritha Nadimpalli
 *
 */

@FeignClient(name = "http://departmentemployeeservice/employeeInfo/")
public interface EmployeeFeignClient {
	
	@GetMapping("/allemployees")
	public List<EmployeeItem> getAllEmployees();

	@PostMapping("/createEmployee")
	public EmployeeItem saveEmployee(@RequestBody EmployeeItem emp);

	@GetMapping("/empId")
	public EmployeeItem getEmpById(@RequestParam("id") long id);
	
	@GetMapping("/empsByIds")
	public Set<EmployeeItem> getEmpsByIds(@RequestParam("ids") Set<Long> ids);
	
	
}
