
package net.antra.sep.springassignment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.antra.sep.springassignment.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login")
	public String showWelcome(@RequestParam String userName, @RequestParam String password, HttpServletRequest req) {
		if(!userService.validateUser(userName, password)) {
			req.getSession().setAttribute("ErrMsg", "Invalid Username or Password!");
			return "login";
		}
		req.getSession().setAttribute("userName", userName);
		req.getSession().setAttribute("password", password);
		req.getSession().setAttribute("clickOnDept", "false");
		return "forward:/getDeptEmpListAtMain";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "login";
	}
}
