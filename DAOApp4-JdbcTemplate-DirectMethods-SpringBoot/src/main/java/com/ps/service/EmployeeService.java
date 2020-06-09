package com.ps.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

	public int fetchAllEmployeeCount();
	public String fetchEmployeeData(int empno);
	public Map<String,Object> fetchOneEmployeeDetails(int empno);
	public List<Map<String,Object>> fetchAllEmployeeDetails();
	public List<Map<String,Object>> fetchAllEmployeeDetailsByDesg(String desg1,String desg2);
	public String createNewEmployeeRecord(int empno,String ename,String job,float sal);
	public String changeEmployeeSalaryByPercentage(float salRange,float percentage);
	public String removeEmployeeByNo(int empno);

}
