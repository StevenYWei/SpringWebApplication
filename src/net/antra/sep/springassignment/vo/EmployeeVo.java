
package net.antra.sep.springassignment.vo;

import org.hibernate.validator.constraints.Length;

//import net.antra.sep.springassignment.entity.Department;

//import net.antra.sep.springassignment.vo.DepartmentVo;

public class EmployeeVo {
	
	private Integer empId;
	@Length(min = 1, max = 20, message = "First name should be at leas one chracter and max 20 characters.")
	private String empFirstName;
	@Length(min = 1, max = 20, message = "Department name should be at leas one chracter and max 20 characters.")
	private String empLastName;
	private Integer empAge;
	private DepartmentVo department;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	public DepartmentVo getDepartmentVo() {
		return department;
	}
	public void setDepartmentVo(DepartmentVo department) {
		this.department = department;
	}

}
