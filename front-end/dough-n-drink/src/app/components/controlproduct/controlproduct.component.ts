import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SubCategory } from 'src/app/models/category/category';
import { Product } from 'src/app/models/product/product';
import { ProductService } from 'src/app/services/product.service';
import { ShareUserDataService } from 'src/app/services/share-user-data.service';

@Component({
  selector: 'app-controlproduct',
  templateUrl: './controlproduct.component.html',
  styleUrls: ['./controlproduct.component.css']
})
export class ControlproductComponent implements OnInit {
  addForm: FormGroup;
  editForm:FormGroup;
  deleteForm:FormGroup;
  visible:boolean=false;
  addVisible:boolean=true;
  editVisible:boolean;
  deleteVisible:boolean
  auth_token:any;
  
  constructor(private _formBuilder:FormBuilder,private _router:Router,private _http:HttpClient,private _productService:ProductService,private _sharedUserData: ShareUserDataService){}
  subCategoryName:string;


  // subCategory

  ngOnInit(): void {
 
    this.addForm = this._formBuilder.group({
      subCtgName:['',[Validators.required]],
      name:['',[Validators.required]],
      size:['',[Validators.required]],
      price:['',[Validators.required]],
      stock:['',[Validators.required]],
      description:['',[Validators.required]],
      image:['']

     
    })

    
    this.editForm = this._formBuilder.group({
      subCtgName:['',[Validators.required]],
      name:['',[Validators.required]],
      size:['',[Validators.required]],
      price:['',[Validators.required]],
      stock:['',[Validators.required]],
      description:['',[Validators.required]],
      image:['']

     
    })


    this.deleteForm = this._formBuilder.group({
      name:['',[Validators.required]]
    })


    // this._sharedUserData.getToken()
    // .subscribe(result  =>{
    //   this.auth_token = result.token;
      
    // })

    this.auth_token=localStorage.getItem("token");

  }



  getProductAdd():Product{
    this.subCategoryName = this.addForm.get('subCtgName')?.value;
    let category =new SubCategory(this.subCategoryName);
    let name = this.addForm.get('name')?.value;
    let size = this.addForm.get('size')?.value;
    let price = this.addForm.get('price')?.value;
    let stock = this.addForm.get('stock')?.value;
    let description = this.addForm.get('description')?.value;
    let image = this.addForm.get('image')?.value;
  
    
  let product =new Product(category,name,size,price,stock,description,image)
    return product;
  }


  // getProductEdit():Product{
  //   let name = this.editForm.get('name')?.value;

  //   this._productService.getProductByName()
  // }




  addProduct():void{
    
    let product = this.getProductAdd();

    if(!this.addForm.valid){
      this.visible=!this.visible;
    }else{
      console.log(this.auth_token);
      this._productService.addProduct(product,this.getHeader(this.auth_token)).subscribe(
        response =>{
          if(response.success){
            alert(response.message)
          }else{
            alert(response.message)
          }
        }
      )
      
    }
  }


  deleteProduct():void{
    let name = this.deleteForm.get('name')?.value;
    if(!this.deleteForm.valid){
      this.visible=!this.visible;
    }else{
      this._productService.deleteProduct(name,this.getHeader(this.auth_token))
      .subscribe(
        response=>{
          if(response.success){
            alert(response.message)
          }else{
            alert(response.message)
          }

        }
      )
    }

  }




  // editProduct():void{
  //   let product = this.getProductEdit();
  //   console.log(product);
    
  //   if(!this.editForm.valid){
  //     this.visible=!this.visible;
  //   }else{
  //     console.log(product);
  //     this._productService.updateProduct(product,this.getHeader(this.auth_token)).subscribe(
  //       response =>{
  //         if(response.success){
  //           alert(response.message)
  //         }else{
  //           alert(response.message)
  //         }
  //       }
  //     )
  //   }
  // }


  getHeader(token:string):any{
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    });
  }


  
changeAddStatus(){
  this.addVisible=true;
  this.editVisible=false;
  this.deleteVisible=false;
}


changeEditStatus(){
  this.addVisible=false;
  this.editVisible=true;
  this.deleteVisible=false;
}

changeDeleteStatus(){
  this.addVisible=false;
  this.editVisible=false;
  this.deleteVisible=true;
}

}
