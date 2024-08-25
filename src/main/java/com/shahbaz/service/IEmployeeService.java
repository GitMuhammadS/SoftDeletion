package com.shahbaz.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shahbaz.entity.Employee;

public interface IEmployeeService {
	
	public Iterable<Employee> getAllEmployees();
	public Page<Employee> getEmployeePageData(Pageable pageable);
	public String insertEmployee(Employee emp);
	public Employee getEmployeeByEno(int eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeByeno(int eno);
	
}
