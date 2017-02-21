
package net.antra.sep.springassignment.ws;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.sep.springassignment.DAO.DepartmentDAO;
import net.antra.sep.springassignment.DAO.EmployeeDAO;
import net.antra.sep.springassignment.entity.Department;
import net.antra.sep.springassignment.entity.Employee;

@Service
public class EmployeeWebServiceImpl implements EmployeeWebService{

	@Autowired
	EmployeeDAO empDAO;
	
	@Autowired
	DepartmentDAO deptDAO;
	
	@Override
	public List<Employee> getEmpByPartialName(String empName) {
		
		return null;
	}
	
	@Override
	@Transactional
	public Integer deleteEmpById(Integer empId) {
		
		try {
			empDAO.delete(empDAO.findOne(empId));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	@Transactional
	public void updateEmp(Integer empId, String empFirstName, String empLastName, Integer empAge, Integer deptNo) {
		Department dept = deptDAO.findOne(deptNo);
		Employee emp = empDAO.findOne(empId);
		emp.setDepartment(dept);
		emp.setEmpFirstName(empFirstName);
		emp.setEmpLastName(empLastName);
		emp.setEmpAge(empAge);
		empDAO.save(emp);
	}
	
	
}
