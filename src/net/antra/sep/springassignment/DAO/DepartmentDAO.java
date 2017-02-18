package net.antra.sep.springassignment.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.antra.sep.springassignment.entity.Department;

@Repository
public interface DepartmentDAO extends JpaRepository<Department, Integer>{

	@Query("select d from Department d")
	public List<Department> getDeptList();
	
}
