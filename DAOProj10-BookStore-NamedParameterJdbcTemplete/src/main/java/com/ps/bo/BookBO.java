package com.ps.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookBO {

	private int bookId;
	private String bookName;
	private String author;
	private float price;
	private String publisher;
	private String status;
	private String category;
}
