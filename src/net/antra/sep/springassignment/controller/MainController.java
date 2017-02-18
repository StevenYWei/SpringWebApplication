
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

@Controller
public class MainController {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value="/getDeptEmpListAtMain")
	public String getDeptList(ModelMap model) {
		model.addAttribute("deptList", deptService.getDeptList());
//		model.addAttribute("empList", empService.getEmpList());
		return "main";
	}
	
	@RequestMapping(value = "/getDeptDetail")
	@ResponseBody
	public Department getDeptDetail(@RequestParam Integer deptId){
		return deptService.getDeparment(deptId);
	}
}
