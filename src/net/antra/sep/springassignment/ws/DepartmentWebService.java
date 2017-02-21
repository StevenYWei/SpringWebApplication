
package net.antra.sep.springassignment.ws;

import java.util.List;

import net.antra.sep.springassignment.entity.Department;

public interface DepartmentWebService {

	List<Department> getDeptByPartialName(String deptName);

	Integer deleteDeptById(Integer deptId);

	void updateDeptBy(Integer deptId, String deptName, String deptEmail);

	List<Department> getAllDept();
	
	Department getDeptById(Integer deptId);
}