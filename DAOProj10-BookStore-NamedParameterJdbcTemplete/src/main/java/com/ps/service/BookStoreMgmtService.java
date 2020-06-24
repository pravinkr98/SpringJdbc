package com.ps.service;

import java.util.List;

import com.ps.dto.BookDTO;

public interface BookStoreMgmtService {

	public List<BookDTO> fetchBookByAuthor(String author1,String author2,String author3);
	public String addBook (BookDTO dto);
	
}
