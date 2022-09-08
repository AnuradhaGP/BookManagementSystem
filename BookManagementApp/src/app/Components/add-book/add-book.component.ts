import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Book } from 'src/app/Models/book';
import { BookService } from 'src/app/Services/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.scss']
})
export class AddBookComponent implements OnInit {

  
  bookForm:FormGroup = new FormGroup({
    name: new FormControl(null,[Validators.required]),
    description: new FormControl(null,[Validators.required]),
    author: new FormControl(null,[Validators.required]),
    price: new FormControl(null,[Validators.required]),
    imageUrl: new FormControl(null,[Validators.required]),

  })

  constructor(private bookService:BookService) { }

  ngOnInit(): void {
  }

    // on add book sumbit
    addBook(){
      const book:Book = new Book(
        0,
        this.bookForm.get('name')?.value,
        this.bookForm.get('description')?.value,
        this.bookForm.get('author')?.value,
        this.bookForm.get('price')?.value,
        this.bookForm.get('imageUrl')?.value,
      );

      this.bookService.addBook(book).subscribe(res=>{
        alert(res.data);
      }, err=>{
        console.log(err);
      })

    }
}
