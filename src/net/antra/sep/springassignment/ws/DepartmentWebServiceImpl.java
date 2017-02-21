
package net.antra.sep.springassignment.ws;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.sep.springassignment.DAO.DepartmentDAO;
import net.antra.sep.springassignment.entity.Department;

@Service
public class DepartmentWebServiceImpl implements DepartmentWebService{

	@Autowired
	DepartmentDAO deptDAO;
	
	@Override
	public List<Department> getDeptByPartialName(String deptName) {
		
		return null;
	}
	
	@Override
	@Transactional
	public Integer deleteDeptById(Integer deptId) {
		
		try {
			deptDAO.delete(deptDAO.findOne(deptId));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	@Override
	@Transactional
	public void updateDeptBy(Integer deptId, String deptName, String deptEmail) {
		Department dept = deptDAO.findOne(deptId);
		dept.setDeptName(deptName);
		dept.setDeptEmail(deptEmail);
		deptDAO.save(dept);
	}

	@Override
	public List<Department> getAllDept() {
		return deptDAO.findAll();
	}

	@Override
	public Department getDeptById(Integer deptId) {
		return deptDAO.findOne(deptId);
	}
	
}
