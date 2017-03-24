package com.steven.hrsystem.vo;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

//import com.steven.hrsystem.entity.Employee;

public class DepartmentVo {
	
	private Integer deptId;
	@Length(min = 1, max = 30, message = "Validation in DepartmentVo: name between 1 and 30 characters.")
	private String deptName;
	@Email(message="Not a valid email")
	private String deptEmail;
	private List<EmployeeVo> employeeList;
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptEmail() {
		return deptEmail;
	}
	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}
	public List<EmployeeVo> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeVo> employeeList) {
		this.employeeList = employeeList;
	}
}
