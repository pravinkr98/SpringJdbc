package com.ps.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookDTO implements Serializable {

	private int bookId;
	private String bookName;
	private String author;
	private float price;
	private String publisher;
	private String status;
	private String category;
}
