package com.employeeservice.repository;

/**
 * @author Haritha Nadimpall
 *
 */
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeservice.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
	
	List<EmployeeEntity> findAllByEmpCodeIn(Set<Long> empcode);
}
