package com.departmentservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.departmentservice.entity.DepartmentEntity;
import com.departmentservice.exception.DepartmentNotFoundException;
import com.departmentservice.exception.EmployeeNotFounException;
import com.departmentservice.model.DepartmentReq;
import com.departmentservice.model.DepartmentRes;
import com.departmentservice.model.EmployeeItem;
import com.departmentservice.repository.DepartmentServiceRepository;

/**
 * @author Haritha Nadimpalli
 *
 */
@Service
public class DepartmentService {
	
	@Autowired
	DepartmentServiceRepository deptServiceRepo;
	
	@Autowired
	EmployeeFeignClient empFeignclient;
	
	private static final Logger LOGGER = LogManager.getLogger(DepartmentService.class);
	
	/**
	 * Get all departments available
	 * 
	 * @return
	 */
	public List<DepartmentRes> getAllDepartments() {
		LOGGER.info("Fetching all deparments");
		List<DepartmentEntity> deptlist=deptServiceRepo.findAll();
		
		List<DepartmentRes> responseList= new ArrayList();
		for(DepartmentEntity dept:deptlist) {
			DepartmentRes response = entityToObject(dept);
			responseList.add(response);
		}
		return responseList;
	}
	
	/**
	 * getting the deprtment details by deptId
	 * 
	 * @param id
	 * @return
	 */
	public DepartmentRes getDeptById(long id) {
		LOGGER.info("Fetching the dept data for given id");
		DepartmentEntity deptObj = deptServiceRepo.findById(id).orElseThrow(() -> new DepartmentNotFoundException());
		DepartmentRes res= entityToObject(deptObj);
	 return  res;
	}
	
	/**
	 * creates department
	 * 
	 * 
	 * @return
	 */
	@Transactional
	public DepartmentRes createDepartment(@RequestBody DepartmentReq deptReq) {
		
		  LOGGER.info("Enter into Departmentsrvice :: createDepartment {} "); 
		  Set<Long> empIds = new HashSet(); 
		  DepartmentEntity deptData=new DepartmentEntity();
		  
		  if (!deptReq.getEmpIds().isEmpty()) {
		  
			  empIds = deptReq.getEmpIds(); // Calling the another
		  //Emploee service to get the empdetails of  department
		  Set<EmployeeItem> empDetails =
				  empFeignclient.getEmpsByIds(empIds); 
		  if (empDetails.size() != empIds.size()) { 
			 throw new EmployeeNotFounException(); 
			 }
		  }
		
		BeanUtils.copyProperties(deptReq, deptData);
		deptData.setEmpIds(empIds);
		DepartmentEntity entityObj=deptServiceRepo.save(deptData);
		DepartmentRes res = entityToObject(entityObj);
		return res;
	}
	
	public DepartmentRes entityToObject(DepartmentEntity dept) {
		DepartmentRes response = new DepartmentRes();
		response.setDeptId(dept.getDeptId());
		response.setDepartmentName(dept.getDepartmentName());
		response.setDeptHead(dept.getDeptHead());
		response.setEmpIds(dept.getEmpIds());
		response.setDepartmentDes(dept.getDepartmentDes());
		
		return response;
	}
	
}
