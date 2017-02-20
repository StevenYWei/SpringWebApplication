
package net.antra.sep.springassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.antra.sep.springassignment.entity.Department;
import net.antra.sep.springassignment.service.DepartmentService;
import net.antra.sep.springassignment.service.EmployeeService;
import net.antra.sep.springassignment.ws.DepartmentWebService;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	DepartmentWebService deptWebService;
	
	@RequestMapping(value="/addDept", method=RequestMethod.POST)
	public String addDepartment(Department newDept) {
		deptService.saveDepartment(newDept);
		return "forward:/reloadDeptEmpListAtDepartment";
	}
	
	@RequestMapping(value="/departmentPage")
	public String goToDepartmentPage() {
		return "forward:/reloadDeptEmpListAtDepartment";
	}
	
	@RequestMapping(value="/reloadDeptEmpListAtDepartment")
	public String reloadDeptList(ModelMap model) {
		model.addAttribute("deptList", deptService.getDeptList());
		model.addAttribute("empList", empService.getEmpList());
		return "department";
	}
	
	@RequestMapping(value="/deleteDept")
	@ResponseBody
	public String deleteDepartment(@RequestParam Integer deptId) {
		System.out.println("In the deleting method...");
		return deptWebService.deleteDeptById(deptId).toString();
	}
	
	@RequestMapping(value="/updateDept")
	@ResponseBody
	public String updateDepartment(@RequestParam Integer deptId, @RequestParam String deptName, @RequestParam String deptEmail) {
		System.out.println("In the update method...");
		deptWebService.updateDeptBy(deptId, deptName, deptEmail);
		return "1";
	}
}
