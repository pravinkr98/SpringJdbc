package com.ps.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeSearchDAOImpl implements EmployeeSearchDAO {
	
	@Autowired
	private JdbcTemplate jt;	
	
	public EmployeeSearchDAOImpl() {
		System.out.println("EmployeeSearchDAOImpl:: 0-param constructor");
	}
	
	//In this example we cannot create dynamic query....  because we are selecting
	//record by using multiple desgs that is coming from select box....

	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesg(String cond) {
		List<Map<String,Object>> listMap=null;
		//get employee details by multiple desg
		listMap=jt.queryForList("SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN "+cond+" ORDER BY JOB", new Object[] {});
		//return list of employee
		return listMap;
	}

}
