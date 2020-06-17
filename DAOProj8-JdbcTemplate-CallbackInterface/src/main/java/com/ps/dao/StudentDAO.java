package com.ps.dao;

import com.ps.bo.StudentBO;

public interface StudentDAO {

	public StudentBO queryForStudentBySno(int no);
}
