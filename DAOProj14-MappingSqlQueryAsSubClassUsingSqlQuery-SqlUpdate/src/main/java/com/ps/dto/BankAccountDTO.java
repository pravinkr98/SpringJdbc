package com.ps.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BankAccountDTO implements Serializable {

	private long acno;
	private String holderName;
	private double balance;
}
