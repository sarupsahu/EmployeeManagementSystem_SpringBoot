package com.jsp.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.DAO.EmployeeDAO;
import com.jsp.DTO.EmployeeDTO;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDAO dao;
	
	
	@RequestMapping("/insert")
	public ModelAndView getEmployee()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", new EmployeeDTO());
		mv.setViewName("create.jsp");
		return mv;
	}
	
	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute EmployeeDTO employee)
	{
		dao.saveEmployee(employee);
		ModelAndView mv2 = new ModelAndView();
		mv2.setViewName("index.jsp");
		return mv2;
	}
	
	
	// API for search an objet in DB based on ID
	@RequestMapping("/search")
	public ModelAndView searchEmployee()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", new EmployeeDTO());
		mv.setViewName("get.jsp");
		return mv;
	}
	
	@RequestMapping("/display")
	public ModelAndView findEmployee(@ModelAttribute EmployeeDTO employee)
	{
		ModelAndView mv2 = new ModelAndView();
		EmployeeDTO emp = dao.getEmployeeById(employee.getId());
		mv2.addObject("employee", emp);
		mv2.setViewName("display.jsp");
		return mv2;
	}
	
	// API for delete an object in DB based on Id
	@RequestMapping("/delete")
	public ModelAndView deleteEmployee()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", new EmployeeDTO());
		mv.setViewName("delete.jsp");
		return mv;
	}
	
	@RequestMapping("/remove")
	public String removeEmployee(@ModelAttribute EmployeeDTO employee)
	{
		
		dao.getEmployeeById(employee.getId());
		
		return "Employee details removed successfully";
	}
	
	//API to get all employee details from DB
	@RequestMapping("/displayAll")
	public ModelAndView getAllEmployee()
	{
		ModelAndView mv = new ModelAndView();
		List<EmployeeDTO> employees = dao.getAllEmployee();
		mv.addObject("employeelist", employees);
		mv.setViewName("displayall.jsp");
		return mv;
	}
	
	//API to update Employee details n Database
	@RequestMapping("/update")
	public ModelAndView updateEmployee()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", new EmployeeDTO());
		mv.setViewName("update.jsp");
		return mv;
	}
	@RequestMapping("/modify")
	public String modifyEmployee(@ModelAttribute EmployeeDTO employee)
	{
		dao.updateEmployee(employee);
		
		return "Employee details Updated Successfully";
	}
}
