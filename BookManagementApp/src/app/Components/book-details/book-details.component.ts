import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Book } from 'src/app/Models/book';
import { BookService } from 'src/app/Services/book.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent implements OnInit {

  constructor(private bookService:BookService) { }

  // search bar form group
  searchBar:FormGroup = new FormGroup({
    search:new FormControl(null)
  });

//  book-list 
  bookList:Book[]=[];

  

  ngOnInit(): void {
    this.bookService.getallbooks().subscribe(res=>{
      this.bookList=res.data;
    },err=>{
      console.log(err);
    });
  }

  // delete books on delete
  deleteItem(id:number){
    if(confirm("Are You sure about deleting this item?")){
      this.bookService.deleteItem(id).subscribe(res=>{
        this.ngOnInit();
        alert(res.data);
      },err=>{
        console.log(err);
      });
    }
  }

  // search book by name
  search(){
    if(this.searchBar.get('search')?.value === ''){
      this.ngOnInit();
    }else{
      this.bookService.searchBook(this.searchBar.get('search')?.value).subscribe(res=>{
        this.bookList=[res.data];
      },err=>{
        alert(err+ " book not found");
      });
    }
  
}
}
