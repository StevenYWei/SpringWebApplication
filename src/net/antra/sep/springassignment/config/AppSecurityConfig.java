package net.antra.sep.springassignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("a").password("1").roles("USER");
		auth.inMemoryAuthentication().withUser("a2").password("2").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("a1").password("1").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')").and().formLogin();
		http
			.authorizeRequests()
				.antMatchers("/", "/getDeptEmpListAtMain").access("hasAnyRole('USER','ADMIN')")
				.antMatchers("/departmentPage", "/addDept", "/deleteDept", "/reloadDeptEmpListAtDepartment").access("hasAnyRole('ADMIN')")
				.antMatchers("/employeePage","/addEmp", "/deleteEmp", "/reloadDeptEmpListAtEmployee").access("hasAnyRole('ADMIN')")
//				.antMatchers("/getDeptDetail").permitAll()
//				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.and()
			.exceptionHandling()
				.accessDeniedPage("/deny")
				.and()
			.logout()
				.permitAll();
	}

}
