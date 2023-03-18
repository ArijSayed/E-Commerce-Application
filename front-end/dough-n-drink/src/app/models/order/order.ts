import { User } from "../user";

export class order {
    OrderId: number;
    price: number;
    odate: Date
    sdate: Date
    total: number
    userid: number
    payment: any


    orderId!: number;
    paymentType!: string;
    shippingDate!: Date;
    orderDate!: Date;
    totalPrice!: number;
    user!: User;

}