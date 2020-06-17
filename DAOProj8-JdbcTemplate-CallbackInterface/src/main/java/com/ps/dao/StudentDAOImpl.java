package com.ps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ps.bo.StudentBO;

//@Repository("studDAO")
public class StudentDAOImpl implements StudentDAO {
	private static final String GET_STUDENT_BY_SNO="SELECT SNO,NAME,ADDRS,AVG,TOTAL,RESULT FROM STUDENT WHERE SNO=?";

	@Autowired
	private JdbcTemplate jt;
	
	public StudentDAOImpl() {
		System.out.println("StudentDAOImpl:: 0-param constructor");
	}
	
	@Override
	public StudentBO queryForStudentBySno(int no) {
		StudentBO bo=null;
		//use JdbcTemplate
		bo=jt.queryForObject(GET_STUDENT_BY_SNO, new StudentRowMapper(), no);
		return bo;
	}
	
	public static class StudentRowMapper implements RowMapper<StudentBO>{

		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentBO bo=null;
			//create studentBo object
			bo=new StudentBO();
			bo.setSno(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setAddrs(rs.getString(3));
			bo.setAvg(rs.getFloat(4));
			bo.setTotal(rs.getFloat(5));
			bo.setResult(rs.getString(6));
			return bo;
		}
		
	}//Inner class

}//class
