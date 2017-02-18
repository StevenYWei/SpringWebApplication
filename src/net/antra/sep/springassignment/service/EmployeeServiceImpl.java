
package net.antra.sep.springassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.sep.springassignment.DAO.DepartmentDAO;
import net.antra.sep.springassignment.DAO.EmployeeDAO;
import net.antra.sep.springassignment.entity.Department;
import net.antra.sep.springassignment.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDAO;
	
	@Autowired
	DepartmentDAO deptDAO;
	
	@Override
	public Employee getEmplyee(Integer empNo) {
		return empDAO.findOne(empNo);
	}
	
	@Override
	public void saveEmployee(String firstname, String lastname, Integer age, Integer deptNo) {
		Department dept = deptDAO.findOne(deptNo);
		Employee newEmployee = new Employee();
		newEmployee.setEmpFirstName(firstname);
		newEmployee.setEmpLastName(lastname);
		
		newEmployee.setEmpAge(age);
		
		newEmployee.setDepartment(dept);
//		newEmployee.setDepartment(deptDAO.findOne(Integer.parseInt(deptNo)));
		empDAO.save(newEmployee);
	}

	@Override
	public List<Employee> getEmpList() {
		return empDAO.getEmptList();
	}

}
