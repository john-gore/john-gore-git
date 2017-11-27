import { Product } from './product';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';


@Injectable()
export class ProductService {
  productsObservable = new BehaviorSubject(null);

  products = [
    new Product(Math.floor(Math.random() * 9999) + 1, 'DSLR Camera', 1499, '../../assets/camera.jpeg'),
    new Product(Math.floor(Math.random() * 9999) + 1, 'iLaptop', 1299, '../../assets/laptop.jpg')
  ];

  constructor() { }

  updateProducts(products: Array<Product>) {
    this.productsObservable.next(products);
  }

}
