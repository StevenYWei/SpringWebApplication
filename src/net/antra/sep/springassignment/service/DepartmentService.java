package net.antra.sep.springassignment.service;

import java.util.List;

import net.antra.sep.springassignment.entity.Department;


public interface DepartmentService {
	
	public void saveDepartment(Department newDept);
	
	public Department getDeparment(Integer deptId);
	
	public List<Department> getDeptList();

}
