package com.shahbaz.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shahbaz.entity.Employee;

@Component
public class EmpValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("EmpValidator.supports()");
		
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("EmpValidator.validate()");
		//type casting
		Employee emp=(Employee)target;
		
		//server side form validation
		if(emp.getEname()==null || emp.getEname().isBlank())
			errors.rejectValue("ename", "emp.ename.required");
		else if(emp.getEname().length()<5)
			errors.rejectValue("ename", "emp.ename.minlength");
		
		
		if(emp.getJob()==null || emp.getJob().isBlank())
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<5)
			errors.rejectValue("job", "emp.job.minlength");
		
		if(emp.getSal()==null)
			errors.rejectValue("sal", "emp.sal.required");
		else if(emp.getSal().isNaN())
			errors.rejectValue("sal", "emp.sal.numeric");
		else if(emp.getSal()<1000 || emp.getSal()>10000)
			errors.rejectValue("sal", "emp.sal.range");
		
		if(emp.getDeptno()==null)
			errors.rejectValue("deptno", "emp.deptno.required");
		else if(((Float)emp.getDeptno().floatValue()).isNaN())
			errors.rejectValue("deptno", "emp.deptno.numeric");
		else if(emp.getDeptno()<10 || emp.getDeptno()>100)
			errors.rejectValue("deptno", "emp.deptno.range");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
