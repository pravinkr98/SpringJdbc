package com.ps.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.ps.bo.StudentBO;

@Repository("studDAO")
public class StudentDAOImpl2 implements StudentDAO {
	private static final String GET_STUDENT_BY_SNO="SELECT SNO,NAME,ADDRS,AVG,TOTAL,RESULT FROM STUDENT WHERE SNO=?";
	private static final String GET_STUDENT_BY_ADDRS="SELECT SNO,NAME,ADDRS,AVG,TOTAL,RESULT FROM STUDENT WHERE ADDRS=?";
	private static final String GET_STUDENTS_BY_CITY="SELECT SNO,NAME,ADDRS,AVG,TOTAL,RESULT FROM STUDENT WHERE ADDRS=?";

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

	@Override
	public List<StudentBO> queryForStudentByAdd(String addr) {
		List<StudentBO> listBO=null;
		listBO=jt.query(GET_STUDENT_BY_ADDRS,  rs->{
				List<StudentBO> listBO1=null;
				//create listBO object
				listBO1=new ArrayList<StudentBO>();
				//Keep resultSet object into bo object
				while(rs.next()) {
					StudentBO bo=new StudentBO();
					bo.setSno(rs.getInt(1));
					bo.setName(rs.getString(2));
					bo.setAddrs(rs.getString(3));
					bo.setAvg(rs.getFloat(4));
					bo.setTotal(rs.getFloat(5));
					bo.setResult(rs.getString(6));
					listBO1.add(bo);
				}
				return listBO1;
			}//Anonymous inner class using lambda expression			
		, addr);
		return listBO;
	}//method	

	@Override
	public List<StudentBO> queryForStudentByCity(String city) {
		List<StudentBO> listBO=new ArrayList<StudentBO>();
		jt.query(GET_STUDENTS_BY_CITY, rs->{
			System.out.println("StudentDAOImpl2.queryForStudentByCity()");
			StudentBO bo=new StudentBO();
			bo.setSno(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setAddrs(rs.getString(3));
			bo.setAvg(rs.getFloat(4));
			bo.setTotal(rs.getFloat(5));
			bo.setResult(rs.getString(6));
			//add into listBO
			listBO.add(bo);	
		}//anonymous inner class
		,city);

		return listBO;
	}

}//class