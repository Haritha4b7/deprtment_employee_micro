package com.employeeservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeservice.entity.EmployeeEntity;
import com.employeeservice.model.EmployeeReq;
import com.employeeservice.model.EmployeeRes;
import com.employeeservice.service.EmployeeService;

/**
 * @author Haritha Nadimpall
 *
 */
@RestController
@RequestMapping("/employeeInfo")
public class EmployeeInfoController {
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeInfoController.class);
	
	@Autowired
	EmployeeService empService;
	
	/**
	 * This method will return all the employee details .
	 * 
	 * @return
	 */
	@GetMapping("/allemployees")
	public ResponseEntity<List<EmployeeRes>> getAllEmployees() {
		LOGGER.info("EmployeeInfoController :: Received Request ....");
		List<EmployeeRes> empList = new ArrayList<EmployeeRes>();
		empList = empService.getAllEmployees();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}
	
	/**
	 * This method will save the employee into Database
	 * 
	 * @param emp request
	 */
	@PostMapping("/createEmployee")
	public ResponseEntity<EmployeeRes> saveEmployee(@Valid @RequestBody EmployeeReq empReq) {
		LOGGER.info("EmployeeInfoController :: Received Request ....");
		EmployeeRes createdEmp = empService.addEmployee(empReq);
		return new ResponseEntity<>(createdEmp, HttpStatus.OK);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/empId")
	public ResponseEntity<EmployeeRes> getEmpById(@RequestParam("id") long id) {
		LOGGER.info("EmployeeInfoController :: Received Request :: getEmpById: " + id);
		EmployeeRes emp = empService.getemployeeById(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	/**
	 * Fetching the department by ids
	 * @param ids
	 * @return
	 */
	@GetMapping("/empsByIds")
	public ResponseEntity<Set<EmployeeRes>> getEmpsByIds(@RequestParam("ids") Set<Long> ids) {
		LOGGER.info("EmployeeInfoController :: Received Request ::  getEmpsByIds: " + ids.toString());
		Set<EmployeeRes> emps = empService.getEmpsByIds(ids);

		return new ResponseEntity<>(emps, HttpStatus.OK);

	}
	
}
