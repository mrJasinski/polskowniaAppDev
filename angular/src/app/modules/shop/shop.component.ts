import { NgFor, NgIf } from "@angular/common";
import { Component } from "@angular/core";
import { RouterLink } from "@angular/router";
import { ShopService } from "./shop.service";
import { Shop } from "./shop.model";

@Component
({
  selector: 'shop',
  templateUrl: './shop.component.html'
  , imports: [NgFor]
})

export class ShopComponent 
{
  shop : Shop;

  constructor(private shopService : ShopService)
  {
    
  }

  ngOnInit()
  {
    this.shopService.getShop().subscribe( response => this.shop = <any>response.body);
  }

  // inicjalizacja koszyka poprzez kliknięcie pierwszy raz dodaj do koszyka?
}