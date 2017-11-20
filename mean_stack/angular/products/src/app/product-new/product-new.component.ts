import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Product } from '../product';
import { ProductService } from './../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-new',
  templateUrl: './product-new.component.html',
  styleUrls: ['./product-new.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProductNewComponent implements OnInit {
  newProduct: Product = new Product();
  products: Array<Product>;

  constructor(
    private _produceService: ProductService,
    private _router: Router
  ) {
    this._produceService.productsObservable.subscribe( (products) => {
      this.products = products;
    });
  }

  ngOnInit() {
    this.newProduct = new Product();
  }
  onSubmit() {
    console.log(this.products);
    this.products.push(this.newProduct);
    this._produceService.updateProducts(this.products);
    this.newProduct = new Product();
    this._router.navigate(['/products']);
  }

}
