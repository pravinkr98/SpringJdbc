package com.ps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ps.bo.StudentBO;

@Repository("studDAO")
public class StudentDAOImpl3 implements StudentDAO {
	private static final String GET_STUDENT_BY_SNO="SELECT SNO,NAME,ADDRS,AVG,TOTAL,RESULT FROM STUDENT WHERE SNO=?";

	@Autowired
	private JdbcTemplate jt;
	
	public StudentDAOImpl3() {
		System.out.println("StudentDAOImpl3:: 0-param constructor");
	}
	
	@Override
	public StudentBO queryForStudentBySno(int no) {
		StudentBO bo=null;
		//use JdbcTemplate
		bo=jt.queryForObject(GET_STUDENT_BY_SNO, new BeanPropertyRowMapper<StudentBO>(StudentBO.class)
		,no);
		return bo;
	}//method
	

}//class