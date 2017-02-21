/**
 * 
 */
package net.antra.sep.springassignment.ws;

import java.util.List;

import net.antra.sep.springassignment.entity.Employee;

/**
 * @author yumingwei
 *
 */
public interface EmployeeWebService {

	List<Employee> getEmpByPartialName(String empName);

	Integer deleteEmpById(Integer empId);

	void updateEmp(Integer empId, String empFirstName, String empLastName, Integer empAge, Integer deptNo);

}