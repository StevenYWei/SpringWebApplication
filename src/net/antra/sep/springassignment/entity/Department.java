package net.antra.sep.springassignment.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "department")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@deptId")
public class Department implements Serializable {

	private static final long serialVersionUID = -5350810416792198549L;
	
	private Integer deptId;
	private String deptName;
	private String deptEmail;
	private List<Employee> employeeList;

	public Department() {}
	
	public Department(Integer deptNo, String deptName, String deptEmail, List<Employee> emp) {
		this.deptId = deptNo;
		this.deptName = deptName;
		this.deptEmail = deptEmail;
		this.employeeList = emp;
	}
	
	public Department(Integer deptNo, String deptName, String deptEmail) {
		this.deptId = deptNo;
		this.deptName = deptName;
		this.deptEmail = deptEmail;
		this.employeeList = new ArrayList<Employee>();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dept_id")
	public Integer getDeptId() {
		return deptId;
	}
	
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Column(name = "dept_name", length = 30, nullable = false)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name="dept_email", length = 50, nullable = true)
	public String getDeptEmail() {
		return deptEmail;
	}

	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}

	@OneToMany(mappedBy="department", fetch=FetchType.EAGER)
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	//  the new employee to the list
	public void addEmployee(Employee newEmp) {
		if(!employeeList.contains(newEmp)) {
			employeeList.add(newEmp);
		}
	}
	
}
