package com.steven.hrsystem.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.steven.hrsystem.entity.Department;

@Repository
public interface DepartmentDAO extends JpaRepository<Department, Integer>{

	@Query("select d from Department d")
	public List<Department> getDeptList();
	
	@Query("select d from Department d where d.deptName like %:deptName%")
	public List<Department> getDeprtmentByPartialName(@Param("deptName") String deptName);
	
}
