package com.ps.service;

import java.util.List;
import java.util.Map;

public interface EmployeeMgmtService {

	public List<Map<String,Object>> fetchEmployeeByDesg(String[] desg);
}
