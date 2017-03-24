
package com.steven.hrsystem.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.steven.hrsystem.entity.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

	@Query("select e from Employee e")
	public List<Employee> getEmptList();
	

}
