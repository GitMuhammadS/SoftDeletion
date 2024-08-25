package com.shahbaz.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="emp1")
@Data
@SQLDelete(sql="UPDATE EMP1 SET STATUS='DELETED' WHERE EMPNO=?")
@Where(clause="STATUS <> 'DELETED'")
public class Employee {
	@Id
	@SequenceGenerator(name="gen1",sequenceName="emp_no_seq1",initialValue=3000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer empno;
	@Column(length=17)
	private String ename;
	@Column(length=17)
	private String job;
	private Float sal;
	private Integer deptno;
	@Column(length=17)
	private String status="active";
	
}
