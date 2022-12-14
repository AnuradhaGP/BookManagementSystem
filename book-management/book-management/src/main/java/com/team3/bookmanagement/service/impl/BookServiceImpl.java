package com.team3.bookmanagement.service.impl;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.bookmanagement.dto.BookDTO;
import com.team3.bookmanagement.entity.Book;
import com.team3.bookmanagement.repository.BookRepo;
import com.team3.bookmanagement.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepo bookRepo;

	@Override
	public String createBook(BookDTO dto) {
		Book book = new Book(dto.getId(),dto.getName(),dto.getDescription(),dto.getAuthor(),dto.getPrice(),dto.getImageUrl());
		return bookRepo.save(book).getName()+" Added Successfully!";
	}

	@Override
	public BookDTO getBook(String name) {
		Book b = bookRepo.findByNameIgnoreCase(name);
		if(b!= null) {
			return new BookDTO(b.getId(),b.getName(),b.getDescription(),b.getAuthor(),b.getPrice(),b.getImageUrl());
		}
		return null;
	}

	@Override
	public List<BookDTO> getAllBook() {
		List<BookDTO> list = new ArrayList<>();
		bookRepo.findAll().forEach(b->{
			list.add(new BookDTO(b.getId(),b.getName(),b.getDescription(),b.getAuthor(),b.getPrice(),b.getImageUrl()));
		});
		return list;
	}

	@Override
	public String updateBook(BookDTO dto) {
		Book book = new Book(dto.getId(),dto.getName(),dto.getDescription(),dto.getAuthor(),dto.getPrice(),dto.getImageUrl());
		return bookRepo.save(book).getId()+"Updated Successfully!";
	}

	@Override
	public String deleteBook(Long id) {
			bookRepo.deleteById(id);
			return id+" deleted Successfully";
	}

	@Override
	public BookDTO getBookById(Long id) {
		Book b = bookRepo.findById(id).get();
		if(b!= null) {
			return new BookDTO(b.getId(),b.getName(),b.getDescription(),b.getAuthor(),b.getPrice(),b.getImageUrl());
		}
		return null;
	}

}
