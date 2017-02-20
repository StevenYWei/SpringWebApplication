
package net.antra.sep.springassignment.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.sep.springassignment.DAO.EmployeeDAO;
import net.antra.sep.springassignment.entity.Employee;

@Service
public class EmployeeWebServiceImpl implements EmployeeWebService{

	@Autowired
	EmployeeDAO empDAO;
	
	@Override
	public List<Employee> getEmpByPartialName(String empName) {
		
		return null;
	}
	
	@Override
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
	public void updateEmpById(Integer empId) {
		
	}
	
	
}
