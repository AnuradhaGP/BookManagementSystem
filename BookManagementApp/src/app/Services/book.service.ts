import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../Models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  baseUrl = "http://localhost:3000/api/v1/book";



  constructor(private http:HttpClient) { }

  //get all books from database
  getallbooks():Observable<any>{
    return this.http.get(this.baseUrl+"/show_books");
  }

  //add new book
  addBook(book:Book):Observable<any>{
    return this.http.post(this.baseUrl+"/add_book",{
            name:book.name,
            description:book.description,
            author:book.author,
            price:book.price,
            imageUrl:book.imageUrl
    });

  }

  //delete a book
  deleteItem(id:number):Observable<any>{
    return this.http.delete(this.baseUrl+"/delete_book?id="+id);
  }

  //search a book by name
  searchBook(name:string):Observable<any>{
    return this.http.get(this.baseUrl+"/search_book/"+name);
  }

  //retrieve a book from database by id
  getBook(id:number):Observable<any>{
    return this.http.get(this.baseUrl+"/get_book/"+id);
  }

  //update database
  updateBook(book:Book):Observable<any>{
    return this.http.put(this.baseUrl+"/update_book",{
            id:book.id,
            name:book.name,
            description:book.description,
            author:book.author,
            price:book.price,
            imageUrl:book.imageUrl
    });

  }
}
