export class Book {

        id:number;
        name:string;
        description:string;
        author:string;
        price:number;
        imageUrl:string;
    
        constructor(
            id:number,
            name:string,
            description:string,
            author:string,
            price:number,
            imageUrl:string,
        ){
            this.id=id,
            this.name=name,
            this.description=description,
            this.author=author,
            this.price=price,
            this.imageUrl=imageUrl
        }
    
   
}
