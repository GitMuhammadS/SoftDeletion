package com.shahbaz.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shahbaz.entity.Employee;
import com.shahbaz.service.IEmployeeService;
import com.shahbaz.validator.EmpValidator;

@Controller
public class EmpController {
	@Autowired
	private IEmployeeService service;
	@Autowired
	private EmpValidator validator;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	/*@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String,Object> map) {
		//use service
		Iterable<Employee> empsList=service.getAllEmployees();
		//keep results as model attribute
		map.put("empsList", empsList);
		//return lvn
		return "employee_report";
	}*/
	
	@GetMapping("/emp_report")
	public String showEmployeeReport(@PageableDefault(page=0,size=6,sort="empno",direction=Direction.ASC) Pageable pageable,  Map<String,Object> map) {
		//use service
		Page<Employee> page=service.getEmployeePageData(pageable);
		//keep results as model attribute
		map.put("pageData", page);
		return "employee_report";
	}
	
	@GetMapping("/insert_employee")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		return "add_employee";
	}
	
	@PostMapping("/insert_employee")
	public String insertEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp,BindingResult errors) {
		if(validator.supports(emp.getClass())) {
			validator.validate(emp, errors);
			if(errors.hasErrors())
				return "add_employee";
		}
		
		if(emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("QUEEN")) {
			errors.rejectValue("job", "emp.job.restriction");
			return "modify_employee";
		}
		
		//use service
		String result=service.insertEmployee(emp);
		//Iterable<Employee> empsList=service.getAllEmployees();
		attrs.addFlashAttribute("resultMsg", result);
		//attrs.addFlashAttribute("empsList", empsList);
		//return lvn
		return "redirect:emp_report";
	}
	
	@GetMapping("/edit_employee")
	public String showEditEmployeeFormPage(@RequestParam("eno") int no,@ModelAttribute("emp") Employee emp) {
		//use service
		Employee emp1=service.getEmployeeByEno(no);
		BeanUtils.copyProperties(emp1, emp);
		return "modify_employee";
		
	}
	
	@PostMapping("/edit_employee")
	public String processEditEmployeePage(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp,BindingResult errors) {
		
		if(validator.supports(emp.getClass())) {
			validator.validate(emp, errors);
			if(errors.hasErrors())
				return "modify_employee";
		}
		
		if(emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("QUEEN")) {
			errors.rejectValue("job", "emp.job.restriction");
			return "modify_employee";
		}
			
		
		//use service
		String result=service.updateEmployee(emp);
		//Iterable<Employee> empsList=service.getAllEmployees();
		//keep result in model attribute
		//attrs.addFlashAttribute("empsList", empsList);
		attrs.addFlashAttribute("resultMsg", result);
		
		//return lvn
		return "redirect:emp_report";
	}
	
	@GetMapping("/delete_employee")
	public String deleteEmployee(@RequestParam("eno") int no,RedirectAttributes attrs) {
		//use service
		String result=service.deleteEmployeeByeno(no);
		
		//Iterable<Employee> empsList=service.getAllEmployees();
		
		
		attrs.addFlashAttribute("resultMsg", result);
		return "redirect:emp_report";
	}
	
}
