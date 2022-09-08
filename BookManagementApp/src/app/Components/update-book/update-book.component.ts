import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/Models/book';
import { BookService } from 'src/app/Services/book.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.scss']
})
export class UpdateBookComponent implements OnInit {

  constructor(private  _router:Router,private router:ActivatedRoute,private bookService:BookService) { }
  //get the selected book object
  public book:Book =<Book>{};
  
  //update form group
  updateForm:FormGroup = new FormGroup({
    name: new FormControl(null),
    description: new FormControl(null),
    author: new FormControl(null),
    price: new FormControl(null),
    imageUrl: new FormControl(null),
  });
  
  ngOnInit(): void {
    let bookid = parseInt(this.router.snapshot.paramMap.get('id')!);
    
    //set initial form values
    this.bookService.getBook(bookid).subscribe(res=>{
      this.book=res.data;
        this.updateForm= new FormGroup({
        name: new FormControl(this.book.name),
        description: new FormControl(this.book.description),
        author: new FormControl(this.book.author),
        price: new FormControl(this.book.price),
        imageUrl: new FormControl(this.book.imageUrl),
      });
    },err=>{
      console.log(err);
    });

    
  }

 
//update function
  update(){
    const b:Book = new Book(
      this.book.id,
      this.updateForm.get('name')?.value,
      this.updateForm.get('description')?.value,
      this.updateForm.get('author')?.value,
      this.updateForm.get('price')?.value,
      this.updateForm.get('imageUrl')?.value,
    );

    this.bookService.updateBook(b).subscribe(res=>{
      alert(res.data);
      this._router.navigate(['/dashboard'])
    }, err=>{
      console.log(err);
    })
  }

}
