package net.antra.sep.springassignment.service;

import java.util.List;

import net.antra.sep.springassignment.entity.Employee;

public interface EmployeeService {

	public Employee getEmplyee(Integer empNo);
	
	public void saveEmployee(String firstname, String lastname, Integer age, Integer deptNo);

	public List<Employee> getEmpList();


}
