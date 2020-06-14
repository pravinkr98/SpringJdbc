package com.ps.service;

import java.util.List;
import java.util.Map;

import com.ps.dao.EmployeeSearchDAO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	private EmployeeSearchDAO dao;	
	
	public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl:: 0-param constructor");
	}

	public EmployeeMgmtServiceImpl(EmployeeSearchDAO dao) {
		System.out.println("EmployeeMgmtServiceImpl.EmployeeMgmtServiceImpl()");
		this.dao = dao;
	}

	@Override
	public List<Map<String, Object>> fetchEmployeeByDesg(String[] desg) {
		List<Map<String,Object>> listMap=null;
		String cond=null;
		StringBuffer sb=null;
		//here StringBuffer is taken because in String when we add something.., always new object will be created..
		//by using StringBuffer when we concate anything only that object is used.., so here one object will be created.
		
		sb=new StringBuffer("(");		//here ( is taken
		//write b.logic
		for(int i=0;i<desg.length;++i) {		
			if(i==desg.length-1)							
				sb.append("'"+desg[i]+"')");		//here if last desg then 'desg')
			else
				sb.append("'"+desg[i]+"',");			//here if not last desg then 'desg', 
		}//for
		
		//convert to string
		cond=sb.toString(); 		//final result ('desg',desg',...)
		
		//use dao
		listMap=dao.getEmployeeDetailsByDesg(cond);
		//return listMap
		return listMap;
	}

}
