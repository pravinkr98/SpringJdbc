package com.ps.service;

import java.util.List;

import com.ps.dto.BankAccountDTO;

public interface BankAccountMgmtService {

	public BankAccountDTO fetchAccountDetailsByAcno(long acno);
	public List<BankAccountDTO> fetchAccountDetailsByBalanceRange(double range1,double range2);
	public String modifyBalanceByRange(double range1,double range2,double amount);
}
