package com.shahbaz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shahbaz.entity.Employee;
import com.shahbaz.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public Iterable<Employee> getAllEmployees() {
		
		return repo.findAll(Sort.by("job").ascending());
	}

	@Override
	public String insertEmployee(Employee emp) {
		
		return "The employee inseted with an id: "+repo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeByEno(int eno) {
		return repo.findById(eno).get();
	}

	@Override
	public String updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return "The record of employee with id: "+repo.save(emp).getEmpno()+" updated successfully ";
	}

	@Override
	public String deleteEmployeeByeno(int eno) {
		//use repo
		repo.deleteById(eno);
		return "The record of employee with id: "+eno+" got deleted successfully";
	}

	@Override
	public Page<Employee> getEmployeePageData(Pageable pageable) {
		
		return repo.findAll(pageable);
	}

	
	
	
}
