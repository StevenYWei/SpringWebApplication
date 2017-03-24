
package com.steven.hrsystem.service;

import java.util.List;


//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.steven.hrsystem.DAO.DepartmentDAO;
import com.steven.hrsystem.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDAO deptDAO;
	
	@Override
	@Transactional
	public void saveDepartment(Department newDept) {
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
//		return deptDAO.getDeptList();
		return deptDAO.findAll();		
	}

}
