
package com.steven.hrsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steven.hrsystem.service.DepartmentService;
import com.steven.hrsystem.service.EmployeeService;
import com.steven.hrsystem.vo.DepartmentVo;
import com.steven.hrsystem.ws.GeoService;

@Controller
public class MainController {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	GeoService geoService;
	
	@RequestMapping(value="/getDeptEmpListAtMain")
	public String getDeptList(@ModelAttribute("VO") DepartmentVo dept, ModelMap model) {
		model.addAttribute("deptList", deptService.getDeptList());
		return "main";
	}	
	
	@RequestMapping(value="/getCountryName")
	@ResponseBody
	public String getCountryName(String IP) {
		System.out.println("The IP is " + IP);
		return geoService.getCountryName(IP);
	}
	
	@RequestMapping(value="/getCountryCode")
	@ResponseBody
	public String getCountryCode(@RequestParam String IP) {
		System.out.println("The IP is " + IP);
		return geoService.getCountryCode(IP);
	}
	
	@ExceptionHandler(Exception.class)
	public String errHanlderInMain() {
		System.out.println("In the exception handling in main...");
		return "errorpage";
	}
	
	@RequestMapping(value="/springForm")
	public String validSpringForm(@ModelAttribute("VO") @Valid DepartmentVo dept, BindingResult bindRes, Error err, ModelMap model) {
		if(bindRes.hasErrors()) {
			model.addAttribute("nameNotGood", "Validation in the Controller Binding: Invalid Name");
		}
//		return "forward:/getDeptEmpListAtMain";
		return "main";
	}
}



