package com.ps.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ps.bo.BookBO;

@Repository("bookDAO")
public class BookStoreDAOImpl implements BookStoreDAO {
	private static final String GET_BOOK_BY_AUTHOR="SELECT BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLISHER,STATUS,CATEGORY FROM BOOK_STORE WHERE AUTHOR IN(:auth1,:auth2,:auth3)";
	private static final String INSERT_BOOK_QUERY="INSERT INTO BOOK_STORE VALUES(BKID_SEQ.NEXTVAL,:bookName,:author,:price,:publisher,:status,:category)";
	@Autowired
	private NamedParameterJdbcTemplate npjt;

	@Override
	public List<BookBO> findBooksByAuthors(String author1, String author2, String author3) {
		List<BookBO> listBO=null;
		Map<String,Object> paramsMap=null;
		paramsMap=new HashMap();
		//Keep param values in map object
		paramsMap.put("auth1", author1);
		paramsMap.put("auth2", author2);
		paramsMap.put("auth3", author3);		
		//use NamedParameterJdbcTemplate dataSource
		listBO=npjt.query(GET_BOOK_BY_AUTHOR, paramsMap, rs->{
			List<BookBO> listBO1=new ArrayList();
			while(rs.next()) {
				BookBO bo=new BookBO();
				bo.setBookId(rs.getInt(1));
				bo.setBookName(rs.getString(2));
				bo.setAuthor(rs.getString(3));
				bo.setPrice(rs.getFloat(4));
				bo.setPublisher(rs.getString(5));
				bo.setStatus(rs.getString(6));
				bo.setCategory(rs.getString(7));
				//add in listBO1 
				listBO1.add(bo);
			}
			//return listBO1;
			return listBO1;			
		});
		return listBO;
	}

	@Override
	public int insertBookDetails(BookBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int count=0;
		bpsps=new BeanPropertySqlParameterSource(bo);
		//use namedParameterJdbcTemplate
		count=npjt.update(INSERT_BOOK_QUERY, bpsps);
		return count;
	}

	/*@Override
	public int insertBookDetails(BookBO bo) {
		MapSqlParameterSource msps=null;
		int count=0;
		//prepare param values
		msps=new MapSqlParameterSource();
		msps.addValue("bookName", bo.getBookName());
		msps.addValue("author", bo.getAuthor());
		msps.addValue("price", bo.getPrice());
		msps.addValue("publisher", bo.getPublisher());
		msps.addValue("status", bo.getStatus());
		msps.addValue("category", bo.getCategory());
		//use namedParameterJdbcTemplate
		count=npjt.update(INSERT_BOOK_QUERY, msps);
		return count;
	}*/

}
