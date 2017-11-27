import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductEditComponent } from './product-edit/product-edit.component';
import { ProductLandingComponent } from './product-landing/product-landing.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductNewComponent } from './product-new/product-new.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: ProductLandingComponent,
    children: [],
  },
  {
    path: 'products',
    pathMatch: 'full',
    component: ProductListComponent,
    children: [],
  },
  {
    path: 'products/new',
    pathMatch: 'full',
    component: ProductNewComponent,
    children: [],
  },
  {
    path: 'products/edit/:id',
    pathMatch: 'full',
    component: ProductEditComponent,
    children: [],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
