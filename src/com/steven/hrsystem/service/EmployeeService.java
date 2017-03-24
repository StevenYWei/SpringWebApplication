package com.steven.hrsystem.service;

import java.util.List;

import com.steven.hrsystem.entity.Employee;

public interface EmployeeService {

	public Employee getEmplyee(Integer empNo);
	
	public void saveEmployee(Employee newEmp, Integer deptNo);

	public List<Employee> getEmpList();


}
