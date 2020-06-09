package com.ps.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_COUNT_EMP_QUERY="SELECT COUNT(*) FROM EMP";
	private static final String GET_DATA_EMP_QUERY="SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String GET_ONE_EMP_QUERY="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String GET_ALL_EMP_QUERY="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	private static final String GET_ALL_EMP_QUERY_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB=? OR JOB=?";
	private static final String INSERT_NEW_EMP_RECORD="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES (?,?,?,?)";
	private static final String UPDATE_EMPLOYEE_SALARY="UPDATE EMP SET SAL=SAL+(SAL*?) WHERE SAL <=?";
	private static final String DELETE_EMPLOYEE_BY_NO="DELETE FROM EMP WHERE EMPNO=?";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int getCountEmployee() {
		int count=0;
		//get all employee count
		count=jt.queryForObject(GET_COUNT_EMP_QUERY, Integer.class);
		return count;
	}

	@Override
	public String getEmployeeData(int empno) {
		String data=null;
		//get employee name
		data=jt.queryForObject(GET_DATA_EMP_QUERY, String.class, empno);
		return data;
	}

	@Override
	public Map<String, Object> getOneEmployeeDetails(int empno) {
		Map<String,Object> map=null;
		//get employee details
		map=jt.queryForMap(GET_ONE_EMP_QUERY, empno);
		return map;
	}

	@Override
	public List<Map<String, Object>> getAllEmployeeDetails() {
		List<Map<String, Object>> listMap=null;
		//get all employee details
		listMap=jt.queryForList(GET_ALL_EMP_QUERY);
		return listMap;
	}

	@Override
	public List<Map<String, Object>> getAllEmployeeDetailsByDesg(String desg1, String desg2) {
		List<Map<String, Object>> listMap=null;
		//get all employee details
		listMap=jt.queryForList(GET_ALL_EMP_QUERY_BY_DESG,desg1,desg2);
		return listMap;
	}

	@Override
	public int insertNewEmployee(int empno, String ename, String job, float sal) {
		int count=0;
		//insert new employee record
		count=jt.update(INSERT_NEW_EMP_RECORD,empno,ename,job,sal);
		return count;
	}

	@Override
	public int updateEmployeeSalaryByPercentage(float salRange, float percentage) {
		//return updated count
		return jt.update(UPDATE_EMPLOYEE_SALARY,(percentage/100),salRange );
	}

	@Override
	public int deleteEmployeeRecord(int empno) {
		// return count for deleted employee
		return jt.update(DELETE_EMPLOYEE_BY_NO, empno);
	}

}
