/**
 * 
 */
package net.antra.sep.springassignment.config;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yumingwei
 * @Date Mar 14, 2017 
 * @Desc: 
 */
public class TestBean {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext();
		ac.getBean("student");   //prototype created
		
		// make singleton thread safe
		// constructor-args in xml
		// HttpSession
		// Hibernate, one
		// bean post processor
		// inner bean
		// static factory method instantiation
		// use Calendar class in Spring
		
	}
}
