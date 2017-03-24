/**
 * 
 */
package com.steven.hrsystem.ws;

import java.util.List;

import com.steven.hrsystem.entity.Employee;

/**
 * @author yumingwei
 *
 */
public interface EmployeeWebService {

	List<Employee> getEmpByPartialName(String empName);

	Integer deleteEmpById(Integer empId);

	void updateEmp(Integer empId, String empFirstName, String empLastName, Integer empAge, Integer deptNo);

}