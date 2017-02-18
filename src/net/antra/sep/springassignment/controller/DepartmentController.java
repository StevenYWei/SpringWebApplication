
package net.antra.sep.springassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.antra.sep.springassignment.service.DepartmentService;
import net.antra.sep.springassignment.service.EmployeeService;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value="/addDept")
	public String addDepartment(@RequestParam String deptName, @RequestParam String deptEmail) {
		deptService.saveDepartment(deptName, deptEmail);
		return "forward:/reloadDeptEmpListAtDepartment";
	}
	
	@RequestMapping(value="/departmentPage")
	public String goToDepartmentPage(ModelMap model) {
		return "forward:/reloadDeptEmpListAtDepartment";
	}
	
	@RequestMapping(value="/reloadDeptEmpListAtDepartment")
	public String reloadDeptList(ModelMap model) {
		model.addAttribute("deptList", deptService.getDeptList());
		model.addAttribute("empList", empService.getEmpList());
		return "department";
	}
}
