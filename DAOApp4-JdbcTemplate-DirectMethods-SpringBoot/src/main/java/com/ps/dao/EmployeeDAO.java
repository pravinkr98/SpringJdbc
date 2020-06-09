package com.ps.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
	public int getCountEmployee();
	public String getEmployeeData(int empno);
	public Map<String,Object> getOneEmployeeDetails(int empno);
	public List<Map<String,Object>> getAllEmployeeDetails();
	public List<Map<String,Object>> getAllEmployeeDetailsByDesg(String desg1,String desg2);
	public int insertNewEmployee(int empno,String ename,String job,float sal);
	public int updateEmployeeSalaryByPercentage(float salRange,float percentage);
	public int deleteEmployeeRecord(int empno);
	
}
