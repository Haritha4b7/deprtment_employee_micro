package com.employeeservice.service;

/**
 * @author Haritha Nadimpalli
 *
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeservice.Exception.EmployeeNotFounException;
import com.employeeservice.entity.EmployeeEntity;
import com.employeeservice.model.EmployeeReq;
import com.employeeservice.model.EmployeeRes;
import com.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeRepository empRepository;
	
	/**
	 * Get all the Employee details
	 * 
	 * @return
	 */
	public List<EmployeeRes> getAllEmployees() {
		LOGGER.info("Inside EmployeeService :: getAllEmployees Method {} ");
		List<EmployeeEntity> empEntity = new ArrayList<>();
		List<EmployeeRes> empResponse = new ArrayList<>();
		empEntity = empRepository.findAll();
		for(EmployeeEntity e :empEntity) {
			EmployeeRes res= new EmployeeRes();
			res= entityToObject(e);
			empResponse.add(res);
		}
		return empResponse;
	}
	
	/**
	 * get the employee details by id
	 * 
	 * @param id
	 * @return
	 */
	public EmployeeRes getemployeeById(long id) {
		LOGGER.info("Inside EmployeeService :: getemployeeById Method {} ");
		EmployeeEntity emp= empRepository.findById(id).orElseThrow(() -> new EmployeeNotFounException());
		EmployeeRes res= entityToObject(emp);
		return res;
	}
	
	/**
	 * Get the emps based on is
	 * 
	 * @param ids
	 * @return
	 */
	public Set<EmployeeRes> getEmpsByIds(Set<Long> ids) {
		LOGGER.info("Inside EmployeeService :: getEmpsByIds Method {} ");
		List<EmployeeEntity> emps = empRepository.findAllByEmpCodeIn(ids);
		Set<EmployeeRes> empList= new HashSet<>();
		
		for(EmployeeEntity e:emps) {
			EmployeeRes emp=new EmployeeRes();
			emp = entityToObject(e);
			empList.add(emp);
		}
		//return emps.stream().collect(Collectors.toSet());
		return empList;

	}
	
	/**
	 * Save the employee into Database.
	 * 
	 * @param emp
	 */
	
	public EmployeeRes addEmployee(EmployeeReq empReq) {
		LOGGER.info("Inside EmployeeService :: addEmployee Method {} ");
		EmployeeEntity empData = new EmployeeEntity();
		BeanUtils.copyProperties(empReq, empData);
		EmployeeEntity savedEmp = empRepository.save(empData);
		
		EmployeeRes empRes= entityToObject(savedEmp);
		return empRes;
	}
	
	public EmployeeRes entityToObject(EmployeeEntity emp) {
		
		EmployeeRes response = new EmployeeRes();
		response.setEmpCode(emp.getEmpCode());
		response.setEmpFirstName(emp.getEmpFirstName());
		response.setEmpLastName(emp.getEmpLastName());
		response.setEmail(emp.getEmail());
		
		return response;
	}
	
}
