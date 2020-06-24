package com.ps.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.bo.DepartmentBO;
import com.ps.dao.DepartmentDAO;
import com.ps.dto.DepartmentDTO;

@Service("deptService")
public class DepartmentMgmtServiceImpl implements DepartmentMgmtService {
	
	@Autowired
	private DepartmentDAO dao;

	@Override
	public String registerDepartment(DepartmentDTO dto) {
		int count=0;
		DepartmentBO bo=null;
		//copy dto to bo
		bo=new DepartmentBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.insertDeptDetails(bo);
		return count==0?"Registration failed":"Registration Succeded";
	}

}
