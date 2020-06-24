package com.ps.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.ps.dto.BookDTO;
import com.ps.service.BookStoreMgmtService;

public class BookStoreNamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BookStoreMgmtService service=null;
		List<BookDTO> listDTO=null;
		BookDTO dto=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get service class bean object
		service=ctx.getBean("bookService", BookStoreMgmtService.class);
		try {
			//invoke find method
			listDTO=service.fetchBookByAuthor("HerbertSchildt", "AlanForbes", "PaulBarry");
			//display book details
			listDTO.forEach(System.out::println);
			
			System.out.println("...................................................................................................");
			//set book details in dto object
			dto=new BookDTO();
			dto.setBookName("Godan");
			dto.setAuthor("MunshiPremchand");
			dto.setPrice(300.0f);
			dto.setPublisher("JaiRatan");
			dto.setStatus("1stEdition");
			dto.setCategory("novel");
			//invoke insert methods
			System.out.println(service.addBook(dto));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
	}

}
