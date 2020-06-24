package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.bo.BookBO;
import com.ps.dao.BookStoreDAO;
import com.ps.dto.BookDTO;

@Service("bookService")
public class BookStoreMgmtServiceImpl implements BookStoreMgmtService {
	
	@Autowired
	private BookStoreDAO dao;

	@Override
	public List<BookDTO> fetchBookByAuthor(String author1, String author2, String author3) {
		List<BookBO> listBO=null;
		List<BookDTO> listDTO=new ArrayList();
		//use dao
		listBO=dao.findBooksByAuthors(author1, author2, author3);
		//Keep listBO object into listDTO
		listBO.forEach(bo->{
			BookDTO dto=new BookDTO();
			//copy bo to dto
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method

	@Override
	public String addBook(BookDTO dto) {
		BookBO bo=null;
		int count=0;
		//copy dto object into bo object
		bo=new BookBO();
		BeanUtils.copyProperties(dto, bo,"bookId");
		//use dao
		count=dao.insertBookDetails(bo);
		return count==0?"Book registration failed":"Book Registration succeded" ;
	}

}//class
