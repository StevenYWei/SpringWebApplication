
package net.antra.sep.springassignment.testing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import net.antra.sep.springassignment.config.MvcConfig;
import net.antra.sep.springassignment.config.PersistenceJPAConfig;
import net.antra.sep.springassignment.entity.Department;
import net.antra.sep.springassignment.entity.Employee;
import net.antra.sep.springassignment.service.DepartmentService;
import net.antra.sep.springassignment.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class,PersistenceJPAConfig.class})
@WebAppConfiguration
public class TestingService {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeService empService;
	
	
	@Test
	public void testGetDeptName() {
		Department dept = deptService.getDeparment(1);
		assertTrue(dept.getDeptName() == "HR");
	}
	@Test
	public void testGetEmpFirstName() {
		Employee emp = empService.getEmplyee(1);
		assertTrue(emp.getEmpAge() == 1);
	}
	
	@Test
	public void Test() {
		assertTrue(1==1);
	}

}
