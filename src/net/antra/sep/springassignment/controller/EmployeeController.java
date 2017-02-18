
package net.antra.sep.springassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.antra.sep.springassignment.service.DepartmentService;
import net.antra.sep.springassignment.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	DepartmentService deptService;
	
	@RequestMapping(value="/employeePage")
	public String goToEmployeePage() {
		return "forward:/reloadDeptEmpListAtEmployee";
	}
	
	@RequestMapping(value="/addEmp")
	public String addEmployee(
			@RequestParam String empFirstName, @RequestParam String empLastName, 
			@RequestParam Integer empAge,  @RequestParam Integer deptSelection) {
		empService.saveEmployee(empFirstName, empLastName, empAge, deptSelection);
		return "forward:/reloadDeptEmpListAtEmployee";
	}
	
	@RequestMapping(value="/reloadDeptEmpListAtEmployee")
	public String reloadDeptList(ModelMap model) {
		model.addAttribute("deptList", deptService.getDeptList());
		model.addAttribute("empList", empService.getEmpList());
		return "employee";
	}

}
