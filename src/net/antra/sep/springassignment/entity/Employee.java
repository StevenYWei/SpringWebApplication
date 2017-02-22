package net.antra.sep.springassignment.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="employee")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@empId")
public class Employee implements Serializable {

	private static final long serialVersionUID = -5455391522951121788L;
	
	private Integer empId;
	private String empFirstName;
	private String empLastName;
	private Integer empAge;
	private Department department;
	
	public Employee() {}
	
	public Employee(Integer empNo, String empFirstName, String empLastName, Integer empAge) {
		this.empId = empNo;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empAge = empAge;
	}
	
	public Employee(Integer empNo, String empFirstName, String empLastName) {
		this.empId = empNo;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empAge = 0;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id", nullable = false)
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Column(name = "first_name", length = 30, nullable = false)
	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	@Column(name = "last_name", length = 30, nullable = false)
	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	@Column(name="age", length = 30, nullable = true)
	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="dept_id")
//	@JsonBackReference
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
}
