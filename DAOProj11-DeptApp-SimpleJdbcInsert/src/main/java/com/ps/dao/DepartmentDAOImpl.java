package com.ps.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ps.bo.DepartmentBO;

@Repository("deptDAO")
public class DepartmentDAOImpl implements DepartmentDAO {
	
	@Autowired
	private SimpleJdbcInsert sji;

	@Override
	public int insertDeptDetails(DepartmentBO bo) {
		Map<String,Object> paramsMap=null;
		int count=0;
		paramsMap=new HashMap();
		paramsMap.put("deptno", bo.getDeptno());
		paramsMap.put("dname", bo.getDname());
		paramsMap.put("loc", bo.getLoc());
		//set table name
		sji.setTableName("DEPT");
		//use simpleJdbcInsert
		count=sji.execute(paramsMap);
		return count;
	}

	/*@Override
	public int insertDeptDetails(DepartmentBO bo) {
		int count=0;
		BeanPropertySqlParameterSource bpsps=null;
		bpsps=new BeanPropertySqlParameterSource(bo);
		//set table name
		sji.setTableName("DEPT");
		count=sji.execute(bpsps);
		return count;
	}*/

}
