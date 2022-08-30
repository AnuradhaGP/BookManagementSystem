package com.team3.bookmanagement.dto;

public class BookDTO {
	private Long id;
	private String name;
	private String description;
	private String author;
	private Double price;
	private String imageUrl;
	
	
	

	public BookDTO() {
		super();
	}
	
	public BookDTO(Long id, String name, String description, String author, Double price, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.author = author;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
