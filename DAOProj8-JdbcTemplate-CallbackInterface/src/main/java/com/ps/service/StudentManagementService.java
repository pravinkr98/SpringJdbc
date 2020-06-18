package com.ps.service;

import java.util.List;

import com.ps.dto.StudentDTO;

public interface StudentManagementService {

	public StudentDTO fetchStudentRecordByNo(int no);
	public List<StudentDTO> fetchStudentRecordByAddrs(String addr);
}
