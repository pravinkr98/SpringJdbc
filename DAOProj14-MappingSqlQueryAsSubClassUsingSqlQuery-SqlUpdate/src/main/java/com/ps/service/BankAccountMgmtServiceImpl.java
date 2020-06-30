package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.bo.BankAccountBO;
import com.ps.dao.BankAccountDAO;
import com.ps.dto.BankAccountDTO;

@Service("bankService")
public class BankAccountMgmtServiceImpl implements BankAccountMgmtService {
	
	@Autowired
	private BankAccountDAO dao;

	@Override
	public BankAccountDTO fetchAccountDetailsByAcno(long acno) {
		BankAccountDTO dto=null;
		BankAccountBO bo=null;
		//use dao
		bo=dao.findAccountDetailsByAcno(acno);
		//Keep bo object data into dto object
		dto=new BankAccountDTO();
		//Copy
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<BankAccountDTO> fetchAccountDetailsByBalanceRange(double range1, double range2) {
		List<BankAccountDTO> listDTO=new ArrayList();
		List<BankAccountBO> listBO=null;
		//use dao
		listBO=dao.findAccountDetailByBalanceRange(range1, range2);
		//Keep listBO object data into listDTO object
		listBO.forEach(bo->{
			BankAccountDTO dto=new BankAccountDTO();
			//copy bo object into dto object
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public String modifyBalanceByRange(double range1, double range2,double amount) {
		int count=0;		
		//use dao
		count=dao.updateBalanceByBalanceRange(range1, range2, amount);
		//return result
		return count==0?"Balance updation failed":+count+" account balance updated with bonus";
	}

}
