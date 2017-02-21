
package net.antra.sep.springassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.antra.sep.springassignment.entity.Employee;
import net.antra.sep.springassignment.service.DepartmentService;
import net.antra.sep.springassignment.service.EmployeeService;
import net.antra.sep.springassignment.ws.EmployeeWebService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeWebService empWebService;
	
	@RequestMapping(value="/employeePage")
	public String goToEmployeePage() {
		return "forward:/reloadDeptEmpListAtEmployee";
	}
	
	@RequestMapping(value="/addEmp")
	public String addEmployee(Employee newEmp,  @RequestParam Integer deptSelection) {
		empService.saveEmployee(newEmp, deptSelection);
		return "forward:/reloadDeptEmpListAtEmployee";
	}
	
	@RequestMapping(value="/reloadDeptEmpListAtEmployee")
	public String reloadDeptList(ModelMap model) {
		model.addAttribute("deptList", deptService.getDeptList());
		model.addAttribute("empList", empService.getEmpList());
		return "employee";
	}
	
	@RequestMapping(value="/deleteEmp")
	@ResponseBody
	public String deleteEmployee(@RequestParam Integer empId) {
		System.out.println("In the deleting method...");
		return empWebService.deleteEmpById(empId).toString();
	}
	
	@RequestMapping(value = "/getEmpDetail")
	@ResponseBody
	public Employee getEmpDetail(@RequestParam Integer empId){
		Employee emp = empService.getEmplyee(empId);		
		return emp;
	}
	@RequestMapping(value="/updateEmp")
	@ResponseBody
	public String updateEmployee(@RequestParam Integer empId, @RequestParam String empFirstName, 
			@RequestParam String empLastName, @RequestParam Integer empAge, @RequestParam Integer deptNo) {
		System.out.println("In the update employee method...");
		empWebService.updateEmp(empId, empFirstName, empLastName, empAge, deptNo);
		return "1";
	}

}
