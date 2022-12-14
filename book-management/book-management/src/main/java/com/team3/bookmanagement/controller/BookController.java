package com.team3.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team3.bookmanagement.dto.BookDTO;
import com.team3.bookmanagement.service.BookService;
import com.team3.bookmanagement.util.StandardResposeEntity;


@RestController
@RequestMapping("api/v1/book")
@CrossOrigin
public class BookController {
	
	@Autowired(required=true)
	private BookService bookService;
	
	@PostMapping("/add_book")
	public ResponseEntity<StandardResposeEntity> createBook(@RequestBody BookDTO dto) {
		return new ResponseEntity<StandardResposeEntity>(
				new StandardResposeEntity(200, "Success!",bookService.createBook(dto)),
				HttpStatus.OK
				);
	}
	
	@GetMapping("/search_book/{name}")
	public ResponseEntity<StandardResposeEntity> getBook(@PathVariable String name) {
		BookDTO dto = bookService.getBook(name);
		if(dto!=null) {
			return new ResponseEntity<StandardResposeEntity>(
					new StandardResposeEntity(200, "Success!",dto),
					HttpStatus.OK
					);
		}
		return new ResponseEntity<StandardResposeEntity>(
				new StandardResposeEntity(404, "User Not Found!",null),
				HttpStatus.NOT_FOUND
				);	
	}
	
	@GetMapping("/get_book/{id}")
	public ResponseEntity<StandardResposeEntity> getBook(@PathVariable Long id) {
		BookDTO dto = bookService.getBookById(id);
		if(dto!=null) {
			return new ResponseEntity<StandardResposeEntity>(
					new StandardResposeEntity(200, "Success!",dto),
					HttpStatus.OK
					);
		}
		return new ResponseEntity<StandardResposeEntity>(
				new StandardResposeEntity(404, "User Not Found!",null),
				HttpStatus.NOT_FOUND
				);	
	}
	
	@GetMapping("/show_books")
	public ResponseEntity<StandardResposeEntity> getAllBooks() {
		List<BookDTO> list = bookService.getAllBook();
		if(!list.isEmpty()) {
			return new ResponseEntity<StandardResposeEntity>(
					new StandardResposeEntity(200, "Success!",list),
					HttpStatus.OK
					);
		}
		return new ResponseEntity<StandardResposeEntity>(
				new StandardResposeEntity(404, "No Books available!",null),
				HttpStatus.NO_CONTENT
				);	
	}
	
	@PutMapping("/update_book")
	public ResponseEntity<StandardResposeEntity> updateBook(@RequestBody BookDTO dto) {
		return new ResponseEntity<StandardResposeEntity>(
				new StandardResposeEntity(200, "Success!",bookService.updateBook(dto)),
				HttpStatus.OK
				);
	}
	
	@DeleteMapping("/delete_book")
	public ResponseEntity<StandardResposeEntity> deleteBook(@RequestParam Long id) {
		return new ResponseEntity<StandardResposeEntity>(
				new StandardResposeEntity(200, "Success!",bookService.deleteBook(id)),
				HttpStatus.OK
				);
	}

	
}
