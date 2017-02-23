
package net.antra.sep.springassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.antra.sep.springassignment.DAO.DepartmentDAO;
import net.antra.sep.springassignment.DAO.EmployeeDAO;
import net.antra.sep.springassignment.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDAO;
	
	@Autowired
	DepartmentDAO deptDAO;
	
	@Override
	@Transactional
	public Employee getEmplyee(Integer empNo) {
		return empDAO.findOne(empNo);
	}
	
	@Override
	@Transactional
	public void saveEmployee(Employee newEmp, Integer deptNo) {
		newEmp.setDepartment(deptDAO.findOne(deptNo));
		empDAO.save(newEmp);
	}
	

	@Override
	@Transactional
	public List<Employee> getEmpList() {
		return empDAO.getEmptList();
	}

}
