package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.bo.StudentBO;
import com.ps.dao.StudentDAO;
import com.ps.dto.StudentDTO;

@Service("studService")
public class StudentManagementServiceImpl implements StudentManagementService {

	@Autowired
	private StudentDAO dao;
	
	@Override
	public StudentDTO fetchStudentRecordByNo(int no) {
		StudentBO bo=null;
		StudentDTO dto=null;
		//use dao
		bo=dao.queryForStudentBySno(no);
		//Keep bo object into dto object
		dto=new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		//return dto
		return dto;
	}

	@Override
	public List<StudentDTO> fetchStudentRecordByAddrs(String addr) {
		 List<StudentBO> listBO=null; 
		//create listDTO object
		List<StudentDTO> listDTO=new ArrayList<StudentDTO>();
		//use DAO
		listBO=dao.queryForStudentByAdd(addr);
		//Keep listBO object into listDTO object
		listBO.forEach(bo->{
			StudentDTO dto=new StudentDTO();
			//copy bo to dto
			BeanUtils.copyProperties(bo, dto,"avg");
			dto.setAvg(Math.round(bo.getAvg()));
			dto.setSrNo(listDTO.size()+1);
			//add dto to listDTO
			listDTO.add(dto);			
		});
		return listDTO;
	}

}
