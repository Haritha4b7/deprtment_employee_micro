package com.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departmentservice.entity.DepartmentEntity;

/**
 * @author Haritha Nadimpalli
 *
 */
public interface DepartmentServiceRepository extends JpaRepository<DepartmentEntity, Long>{

}
