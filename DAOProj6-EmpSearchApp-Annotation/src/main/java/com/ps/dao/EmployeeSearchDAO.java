package com.ps.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeSearchDAO {

	public List<Map<String,Object>> getEmployeeDetailsByDesg(String cond);
	
}
