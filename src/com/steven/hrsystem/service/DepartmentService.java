package com.steven.hrsystem.service;

import java.util.List;

import com.steven.hrsystem.entity.Department;


public interface DepartmentService {
	
	public void saveDepartment(Department newDept);
	
	public Department getDeparment(Integer deptId);
	
	public List<Department> getDeptList();

}
