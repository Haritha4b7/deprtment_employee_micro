package com.departmentservice.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.departmentservice.entity.DepartmentEntity;
import com.departmentservice.model.DepartmentReq;
import com.departmentservice.model.DepartmentRes;
import com.departmentservice.service.DepartmentService;

/**
 * 
 * @author HarithaNadimpalli
 *
 */
/**
 * In this class have the all the methods related to Organization Department
 */
@RestController
@RequestMapping("/department")
public class OrgDepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	private static final Logger LOGGER = LogManager.getLogger(OrgDepartmentController.class);
	/**
	 * It will return the all Department Data
	 * 
	 * @return list of departments
	 */
	@GetMapping("")
	public ResponseEntity<List<DepartmentRes>> getAllDepartments() {
		LOGGER.info("Enter into  OrgDepartmentController : getAllDepartments method {} ");
		List<DepartmentRes> deptDataList = new ArrayList<DepartmentRes>();
		deptDataList = deptService.getAllDepartments();
		return new ResponseEntity<>(deptDataList, HttpStatus.OK);
	}
	
	/**
	 * getting the dept details by detId
	 * 
	 * @param id
	 * @return
	 */
	
	@GetMapping("/deptId")
	public ResponseEntity<DepartmentRes> getDepartmentById(@RequestParam("id") long id) {
		LOGGER.info("EmployeeInfoController :: Received Request :: getEmpById: " + id);
		DepartmentRes emp = deptService.getDeptById(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	/**
	 * Save the Department details into Database with given request
	 * 
	 * @param department
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<DepartmentRes> saveDepartment(@Valid @RequestBody DepartmentReq deptReq) {
		LOGGER.info("Enter into  OrgDepartmentController : saveDepartment method {} ");

		DepartmentRes createdDept = deptService.createDepartment(deptReq);
		return new ResponseEntity<>(createdDept, HttpStatus.OK);
	}
	
}
