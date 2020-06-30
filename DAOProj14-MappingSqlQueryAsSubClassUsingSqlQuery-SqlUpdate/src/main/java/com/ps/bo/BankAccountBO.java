package com.ps.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BankAccountBO {

	private long acno;
	private String holderName;
	private double balance;
}
