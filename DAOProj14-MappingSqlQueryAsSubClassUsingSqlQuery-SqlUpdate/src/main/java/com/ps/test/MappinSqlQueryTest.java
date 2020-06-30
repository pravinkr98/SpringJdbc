package com.ps.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.ps.dto.BankAccountDTO;
import com.ps.service.BankAccountMgmtService;

public class MappinSqlQueryTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankAccountMgmtService service=null;
		List<BankAccountDTO> listDTO=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get service class bean object
		service=ctx.getBean("bankService", BankAccountMgmtService.class);
		
		System.out.println("....................................................................................");
		//invoke method 1
		try {
			System.out.println(service.fetchAccountDetailsByAcno(1002));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}//try
		
		System.out.println("......................................................................................");
		//invoke method 2
		try {
			listDTO=service.fetchAccountDetailsByBalanceRange(100000, 300000);
			listDTO.forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}//try
		
		System.out.println("......................................................................................");
		//invoke method 2
		try {
			System.out.println(service.modifyBalanceByRange(0, 200000, 25000));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}//try
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main

}//class
