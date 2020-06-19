package com.ps.dao;

import java.util.List;

import com.ps.bo.StudentBO;

public interface StudentDAO {

	public StudentBO queryForStudentBySno(int no);
	public List<StudentBO> queryForStudentByAdd(String addr);
	public List<StudentBO> queryForStudentByCity(String city);
}
