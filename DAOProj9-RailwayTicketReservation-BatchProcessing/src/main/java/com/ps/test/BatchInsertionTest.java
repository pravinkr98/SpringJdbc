package com.ps.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.dto.PersonDetailsDTO;
import com.ps.service.RailwayTicketMgmtService;
import com.ps.service.RailwayTicketMgmtServiceImpl;

public class BatchInsertionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		RailwayTicketMgmtService service=null;
		Scanner sc=null;
		int numberOfPassenger=0;
		String sourcePlace=null,destPlace=null;
		float fare=0.0f;
		List<PersonDetailsDTO> listDTO=null;
		String result=null,option=null;
		try {
			//create IOC container
			ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
			//get Service class bean object
			service=ctx.getBean("railwayService", RailwayTicketMgmtServiceImpl.class);
			//take input from end user
			sc=new Scanner(System.in);
				do {
					try {
						System.out.println("How many passengers wants to go ?");
						numberOfPassenger=sc.nextInt();
						option="n";
					}
					catch(Exception e) {
							System.out.print("please input only numbers :: ");
							System.out.println("Do you want to enter passenger number y/n");
							sc.nextLine();
							option=sc.next();
							if(option.equalsIgnoreCase("n")) {
								System.out.println("Program terminated mannualy");
								System.exit(0);
							}
					}	
				}while(!option.equalsIgnoreCase("n"));			 
			
			if(numberOfPassenger>0) {
				System.out.println("What is the starting place ?");
				sourcePlace=sc.next();
				System.out.println("Enter the Destination place ");
				destPlace=sc.next();
				System.out.println("Enter the fare");
				fare=sc.nextFloat();
				//take passenger details from end user and insert into listDTO
				listDTO=new ArrayList<>();
				for(int i=1;i<=numberOfPassenger;++i) {
					PersonDetailsDTO dto=new PersonDetailsDTO();
					System.out.println("Enter "+i+" passenger name");
					dto.setName(sc.next());
					System.out.println("Enter passenger age");
					dto.setAge(sc.nextInt());
					System.out.println("Enter passenger gender");
					dto.setGender(sc.next());
					dto.setStartPlace(sourcePlace);
					dto.setDestinationPlace(destPlace);
					dto.setFare(fare);
					//add into listDTO
					listDTO.add(dto);			
				}//for
			}//if
			else {
				System.out.println("Wrong number is inserted :: Program terminated mannualy");
				System.exit(0);
			}
			
			try {
				//invoke service method
				result=service.groupReservationOfTicket(listDTO);
				System.out.println(result);
			}
			catch(Exception e) {
				e.printStackTrace();
			}		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ctx!=null)
					((AbstractApplicationContext) ctx).close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//main

}//class
