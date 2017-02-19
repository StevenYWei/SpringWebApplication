package net.antra.sep.springassignment.vo;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

//import net.antra.sep.springassignment.entity.Employee;

public class DepartmentVo {
	
	private Integer deptId;
	@Length(min = 1, max = 30, message = "Department name should be at leas one chracter and max 30 characters.")
	private String deptName;
	@Email
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
