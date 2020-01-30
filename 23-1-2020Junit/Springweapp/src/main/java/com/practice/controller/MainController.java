package com.practice.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.config.AppConfig;
import com.practice.models.Employee;
import com.practice.models.datasource;

import dao.EmployeeDao;

@Controller
public class MainController {
	@RequestMapping("/home")
	public String add() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView saveUser(Employee employee) throws ClassNotFoundException {

		ModelAndView model = new ModelAndView("userDetails");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		datasource datasource = context.getBean(datasource.class);

		EmployeeDao employeeDAO = new EmployeeDao();
		employeeDAO.setDataSource(datasource);
		employeeDAO.save(employee);

		model.addObject("employee", employee);
		return model;
	}

	@GetMapping("/view/{id}")
	public ModelAndView viewUser(@PathVariable String id) throws ClassNotFoundException {

		ModelAndView model = new ModelAndView("view");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		datasource datasource = context.getBean(datasource.class);

		EmployeeDao employeeDAO = new EmployeeDao();
		employeeDAO.setDataSource(datasource);
		Employee employee = employeeDAO.getById(Integer.parseInt(id));

		model.addObject("employee", employee);
		return model;
	}

	@RequestMapping("/viewall")
	public ModelAndView viewAllUser() throws ClassNotFoundException {

		ModelAndView model = new ModelAndView("viewall");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		datasource datasource = context.getBean(datasource.class);

		EmployeeDao employeeDAO = new EmployeeDao();
		employeeDAO.setDataSource(datasource);
		List<Employee> employee = employeeDAO.getAll();

		model.addObject("employee", employee);
		return model;
	}

	@RequestMapping("/delete")
	public String DeletePage() {
		return "delete";
	}

	@RequestMapping(value = "/deletedata", method = RequestMethod.POST)
	public ModelAndView saveUser(int id) throws ClassNotFoundException {
		ModelAndView model = new ModelAndView("delete");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		datasource datasource = context.getBean(datasource.class);

		EmployeeDao employeeDAO = new EmployeeDao();
		employeeDAO.setDataSource(datasource);
		String result = employeeDAO.deleteById(id);

		model.addObject("result", result);
		return model;
	}

	@RequestMapping("/view")
	public String viewpage() {
		return "view";
	}

	@RequestMapping(value = "/viewdata", method = RequestMethod.POST)
	public ModelAndView saveUser1(int id) throws ClassNotFoundException {

		ModelAndView model = new ModelAndView("view");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		datasource datasource = context.getBean(datasource.class);

		EmployeeDao employeeDAO = new EmployeeDao();
		employeeDAO.setDataSource(datasource);
		Employee employee = employeeDAO.getById(id);

		model.addObject("employee", employee);
		return model;
	}

	@RequestMapping("/edit")
	public String EditPage() {
		return "edit";
	}

	@RequestMapping(value = "/fetch", method = RequestMethod.POST)
	public ModelAndView saveUser3(int id) throws ClassNotFoundException {

		ModelAndView model = new ModelAndView("edit");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		datasource datasource = context.getBean(datasource.class);

		EmployeeDao employeeDAO = new EmployeeDao();
		employeeDAO.setDataSource(datasource);
		Employee employee = employeeDAO.getById(id);

		model.addObject("employee", employee);
		return model;
	}

	@RequestMapping(value = "/editdata", method = RequestMethod.POST)
	public ModelAndView saveUser2(Employee employee) throws ClassNotFoundException {

		ModelAndView model = new ModelAndView("edit");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		datasource datasource = context.getBean(datasource.class);

		EmployeeDao employeeDAO = new EmployeeDao();
		employeeDAO.setDataSource(datasource);
		String r = employeeDAO.update(employee);

		model.addObject("result", r);
		return model;
	}
}
