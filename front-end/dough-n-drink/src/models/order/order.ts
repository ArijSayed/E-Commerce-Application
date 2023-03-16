import { User } from "../user";


export class Order{
    orderId!:number;
    paymentType!:string;
    shippingDate!:Date;
    orderDate!:Date;
    totalPrice!:number;
    user!:User;
}