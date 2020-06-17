package com.ps.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentDTO implements Serializable {

	private int sno;
	private String name;
	private String addrs;
	private float avg;
	private float total;
	private String result;
}
