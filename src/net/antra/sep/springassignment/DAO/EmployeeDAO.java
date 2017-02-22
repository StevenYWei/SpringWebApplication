
package net.antra.sep.springassignment.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.antra.sep.springassignment.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

	@Query("select e from Employee e")
	public List<Employee> getEmptList();
	

}
