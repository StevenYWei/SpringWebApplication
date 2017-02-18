
package net.antra.sep.springassignment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.sep.springassignment.DAO.DepartmentDAO;
import net.antra.sep.springassignment.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDAO deptDAO;
	
	@Override
	@Transactional
	public void saveDepartment(String deptName, String deptEmail) {
		Department newDept = new Department();
		newDept.setDeptName(deptName);
		newDept.setDeptEmail(deptEmail);
		deptDAO.save(newDept);
	}

	@Override
	@Transactional
	public Department getDeparment(Integer deptId) {
		return deptDAO.findOne(deptId);
	}
	
	@Override
	@Transactional
	public List<Department> getDeptList() {
		return deptDAO.getDeptList();
	}

	@Override
	@Transactional
	public List<Department> getDeptListWithEmployee() {
		return null;
	}

}
