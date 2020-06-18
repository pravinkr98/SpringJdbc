package com.ps.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.ps.bo.StudentBO;

//@Repository("studDAO")
public class StudentDAOImpl3 implements StudentDAO {
	private static final String GET_STUDENT_BY_SNO="SELECT SNO,NAME,ADDRS,AVG,TOTAL,RESULT FROM STUDENT WHERE SNO=?";
	private static final String GET_STUDENT_BY_ADDRS="SELECT SNO,NAME,ADDRS,AVG,TOTAL,RESULT FROM STUDENT WHERE ADDRS=?";

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

	@Override
	public List<StudentBO> queryForStudentByAdd(String addr) {
		List<StudentBO> listBO=null;
		//use JdbcTemplate
		//listBO=jt.query(GET_STUDENT_BY_ADDRS, new RowMapperResultSetExtractor<List<StudentBO>>(new BeanPropertyRowMapper<StudentBO>(StudentBO.class)), addr);
		//listBO=jt.query(GET_STUDENT_BY_ADDRS,new BeanPropertyResultSetExtractor<List<StudentBO>>(StudentBO.class),addr);
		return listBO;
	}
	

}//class