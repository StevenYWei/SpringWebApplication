
package net.antra.sep.springassignment.controller;

import java.util.List;

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
import net.antra.sep.springassignment.vo.DepartmentVo;
import net.antra.sep.springassignment.vo.EmployeeVo;

@Controller
public class MainController {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value="/getDeptEmpListAtMain")
	public String getDeptList(ModelMap model) {
		model.addAttribute("deptList", deptService.getDeptList());
		return "main";
	}
	
	@RequestMapping(value = "/getDeptDetail")
	@ResponseBody
	public Department getDeptDetail(@RequestParam Integer deptId){
		Department dept = deptService.getDeparment(deptId);
//		DepartmentVo deptVo = new DepartmentVo();
//		deptVo.setDeptId(deptId);
//		deptVo.setDeptName(dept.getDeptName());
//		deptVo.setDeptEmail(dept.getDeptEmail());
//		deptVo.setEmployeeList((List<EmployeeVo>) (Object)dept.getEmployeeList());
		
		return dept;
	}
	
	
}
