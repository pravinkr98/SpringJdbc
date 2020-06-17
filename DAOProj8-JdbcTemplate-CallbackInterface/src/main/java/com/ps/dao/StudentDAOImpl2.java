package com.ps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ps.bo.StudentBO;

//@Repository("studDAO")
public class StudentDAOImpl2 implements StudentDAO {
	private static final String GET_STUDENT_BY_SNO="SELECT SNO,NAME,ADDRS,AVG,TOTAL,RESULT FROM STUDENT WHERE SNO=?";

	@Autowired
	private JdbcTemplate jt;
	
	public StudentDAOImpl2() {
		System.out.println("StudentDAOImpl2:: 0-param constructor");
	}
	
	@Override
	public StudentBO queryForStudentBySno(int no) {
		StudentBO bo=null;
		//use JdbcTemplate
		bo=jt.queryForObject(GET_STUDENT_BY_SNO, (rs,rowNum)-> {
				StudentBO bo1=null;
				//create studentBo object
				bo1=new StudentBO();
				bo1.setSno(rs.getInt(1));
				bo1.setName(rs.getString(2));
				bo1.setAddrs(rs.getString(3));
				bo1.setAvg(rs.getFloat(4));
				bo1.setTotal(rs.getFloat(5));
				bo1.setResult(rs.getString(6));
				return bo1;
			}
		,no);
		return bo;
	}//method
	

}//class