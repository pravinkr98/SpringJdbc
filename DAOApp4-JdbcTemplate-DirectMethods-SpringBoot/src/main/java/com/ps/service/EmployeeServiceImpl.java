package com.ps.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dao.EmployeeDAO;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public int fetchAllEmployeeCount() {
		//return emp count
		return dao.getCountEmployee();
	}

	@Override
	public String fetchEmployeeData(int empno) {
		//return emp data
		return dao.getEmployeeData(empno);
	}

	@Override
	public Map<String, Object> fetchOneEmployeeDetails(int empno) {
		// return one employee details
		return dao.getOneEmployeeDetails(empno);
	}

	@Override
	public List<Map<String, Object>> fetchAllEmployeeDetails() {
		// return all employee details
		return dao.getAllEmployeeDetails();
	}

	@Override
	public List<Map<String, Object>> fetchAllEmployeeDetailsByDesg(String desg1, String desg2) {
		// return all employee details by desg
		return dao.getAllEmployeeDetailsByDesg(desg1, desg2);
	}

	@Override
	public String createNewEmployeeRecord(int empno, String ename, String job, float sal) {
		int count=0;
		// insert new employee record
		count=dao.insertNewEmployee(empno, ename, job, sal);
		return count==0?"Registration failed":"Registration successful";
	}

	@Override
	public String changeEmployeeSalaryByPercentage(float salRange, float percentage) {
		int count=0;
		// use dao
		count=dao.updateEmployeeSalaryByPercentage(salRange, percentage);
		//return how many employee are affected
		return count+" employee are affected";
	}

	@Override
	public String removeEmployeeByNo(int empno) {
		int count=0;
		//use dao
		count=dao.deleteEmployeeRecord(empno);
		// return deleted count
		return count+" employee deleted";
	}

}
