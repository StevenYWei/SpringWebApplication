/**
 * 
 */
package net.antra.sep.springassignment.ws;

import java.util.List;

import net.antra.sep.springassignment.entity.Department;

/**
 * @author yumingwei
 *
 */
public interface DepartmentWebService {

	List<Department> getDeptByPartialName(String deptName);

	Integer deleteDeptById(Integer deptId);

	void updateDeptBy(Integer deptId, String deptName, String deptEmail);

}