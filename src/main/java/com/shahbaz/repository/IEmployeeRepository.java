package com.shahbaz.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.shahbaz.entity.Employee;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer>,CrudRepository<Employee,Integer>{
	

}
