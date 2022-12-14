package com.team3.bookmanagement.service;

import java.util.List;



import com.team3.bookmanagement.dto.BookDTO;


public interface BookService {
	public String createBook(BookDTO dto);
	public BookDTO getBook(String name);
	public BookDTO getBookById(Long id);
	public List<BookDTO> getAllBook();
	public String updateBook(BookDTO dto);
	public String deleteBook(Long id);
}
