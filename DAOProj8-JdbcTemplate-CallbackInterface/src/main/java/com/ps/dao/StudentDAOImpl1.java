package com.ps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.ps.bo.StudentBO;

//@Repository("studDAO")
public class StudentDAOImpl1 implements StudentDAO {
	private static final String GET_STUDENT_BY_SNO="SELECT SNO,NAME,ADDRS,AVG,TOTAL,RESULT FROM STUDENT WHERE SNO=?";
	private static final String GET_STUDENT_BY_ADDRS="SELECT SNO,NAME,ADDRS,AVG,TOTAL,RESULT FROM STUDENT WHERE ADDRS=?";

	@Autowired
	private JdbcTemplate jt;
	
	public StudentDAOImpl1() {
		System.out.println("StudentDAOImpl1:: 0-param constructor");
	}
	
	@Override
	public StudentBO queryForStudentBySno(int no) {
		StudentBO bo=null;
		//use JdbcTemplate
		bo=jt.queryForObject(GET_STUDENT_BY_SNO, new RowMapper<StudentBO>() {

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
			}//mapRow
				
		}//Inner class
		,no);
		return bo;
	}//method

	@Override
	public List<StudentBO> queryForStudentByAdd(String addr) {
		List<StudentBO> listBO=null;
		listBO=jt.query(GET_STUDENT_BY_ADDRS, new ResultSetExtractor<List<StudentBO>>(){

			@Override
			public List<StudentBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<StudentBO> listBO=null;
				//create listBO object
				listBO=new ArrayList<StudentBO>();
				//Keep resultSet object into bo object
				while(rs.next()) {
					StudentBO bo=new StudentBO();
					bo.setSno(rs.getInt(1));
					bo.setName(rs.getString(2));
					bo.setAddrs(rs.getString(3));
					bo.setAvg(rs.getFloat(4));
					bo.setTotal(rs.getFloat(5));
					bo.setResult(rs.getString(6));
					listBO.add(bo);
				}
				return listBO;
			}			
		}//anonymous inner class
		, addr);
		return listBO;
	}//method	

}//class