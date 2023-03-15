import { SubCategory } from "../category/category";

export class Product{
  productId:number;
  subCategory:SubCategory;
  name:string;
  size:string;
  price:number;
  stock: string;
  description:string;
  image:string;
  quantity!:any

  constructor(subCategory:SubCategory,name:string,size:string,
    price:number,stock: string,description:string,image:string){
    this.subCategory =subCategory;
    this.name=name;
    this.size=size;
    this.price=price;
    this.stock=stock;
    this.description=description;
    this.image=image;
   }


   
}