
package net.antra.sep.springassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.antra.sep.springassignment.service.DepartmentService;
import net.antra.sep.springassignment.service.EmployeeService;
import net.antra.sep.springassignment.ws.GeoService;

@Controller
public class MainController {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	GeoService geoService;
	
	@RequestMapping(value="/getDeptEmpListAtMain")
	public String getDeptList(ModelMap model) {
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
}
