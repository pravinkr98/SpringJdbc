package com.ps.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonDetailsDTO implements Serializable {

	private String name;
	private int age;
	private String gender;
	private String startPlace;
	private String destinationPlace;
	private float fare;
	
}
