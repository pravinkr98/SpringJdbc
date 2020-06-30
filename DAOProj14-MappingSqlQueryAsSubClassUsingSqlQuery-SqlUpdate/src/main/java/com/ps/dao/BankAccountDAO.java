package com.ps.dao;

import java.util.List;

import com.ps.bo.BankAccountBO;

public interface BankAccountDAO {

	public BankAccountBO findAccountDetailsByAcno(long acno);
	public List<BankAccountBO> findAccountDetailByBalanceRange(double range1,double range2);
	public int updateBalanceByBalanceRange(double range1,double range2, double amount);
}
