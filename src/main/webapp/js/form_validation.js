function validate(frm){
	//empty form validation error message
	document.getElementById("enameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	document.getElementById("deptnoErr").innerHTML="";
	
	//read form data
	let name=frm.ename.value;
	let desg=frm.job.value;
	let salary=frm.sal.value;
	let deptno=frm.deptno.value;
	let validationFlag=true;
	
	//form validation logic
	if(name==""){
		document.getElementById("enameErr").innerHTML="EMPLOYEE NAME IS REQUIRED";
		validationFlag=false;
	}
	else if(name.length()<5){
		document.getElementById("enameErr").innerHTML="EMPLOYEE NAME MUST HAVE MINIMUM OF 5 CHARACTERS"
		validationFlag=false;
	}
	
	if(desg==""){
		document.getElementById("jobErr").innerHTML="EMPLOYEE DESIGNATION REQUIRED";
		validationFlag=false;
	}
	else if(desg.length()<5){
		document.getElementById("jobErr").innerHTML="EMPLOYEE DESG MUST HAVE MINIMUM OF 5 CHARACTERS";
		validationFlag=false;
	}
	
	if(salary==""){
		document.getElementById("salErr").innerHTML="EMPLOYEE SALARY MUST BE REQUIRED";
		validationFlag=false;
	}
	else if(isNaN(salary)){
		document.getElementById("salErr").innerHTML="EMPLOYEE SALARY MUST BE NUMERIC";
		validationFlag=false;
	}
	else if(salary<1000 || salary>10000){
		document.getElementById("salErr").innerHTML="EMPLOYEE SALARY MUST BE IN RANGE OF 1000 AND 10000";
		validationFlag=false;
	}
	
	if(deptno=""){
		document.getElementById("deptnoErr").innerHTML="EMPLOYEE DEPTNO IS REQUIRED";
		validationFlag=false;
	}
	else if(isNaN(deptno)){
		document.getElementById("deptnoErr").innerHTML="EMPLOYEE DEPTNO MUST BE NUMERIC";
		validationFlag=false;
	}
	else if(deptno<10 || deptno>100){
		document.getElementById("deptnoErr").innerHTML="EMPLOYEE DEPTNO MUST BE RANGE OF 10 AND 100";
		validationFlag=false;
	}
     return validationFlag;	
}