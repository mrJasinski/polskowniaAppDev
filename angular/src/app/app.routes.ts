import { Routes } from '@angular/router';
import { HomeComponent } from './modules/home/home.component';
import { AuthComponent } from './modules/auth/auth.component';
import { ShopComponent } from './modules/shop/shop.component';
import { DashboardComponent } from './modules/dashboard/dashboard.component';
import { CartComponent } from './modules/shop/cart/cart.component';

export const routes: Routes = 
[
    { path : '', component : HomeComponent}
    , { path : 'authenticate', component : AuthComponent}
    , { path : 'dashboard', component : DashboardComponent}
    , { path : 'shop', component : ShopComponent}
    , { path : 'cart', component : CartComponent}
    , { path : 'aboutMe', component : CartComponent}
    , { path : 'articles', component : CartComponent}
    , { path : 'contact', component : CartComponent}
];
