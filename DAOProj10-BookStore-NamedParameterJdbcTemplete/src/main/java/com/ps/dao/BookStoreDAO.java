package com.ps.dao;

import java.util.List;

import com.ps.bo.BookBO;

public interface BookStoreDAO {

	public List<BookBO> findBooksByAuthors(String author1,String author2,String author3);
	public int insertBookDetails(BookBO bo);

}
