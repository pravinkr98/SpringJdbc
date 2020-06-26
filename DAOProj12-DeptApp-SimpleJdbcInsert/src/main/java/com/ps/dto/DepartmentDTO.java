package com.ps.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DepartmentDTO implements Serializable {

	private Integer deptno;
	private String dname;
	private String loc;
}
