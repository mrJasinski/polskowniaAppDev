import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AppConstants } from "../../constans/app.constans";

@Injectable({providedIn: 'root'})
export class ShopService
{
    constructor(private http: HttpClient)
    {

    }

    getShop()
    {
        return this.http.get(AppConstants.APP_URL + AppConstants.SHOP_URL, { observe : 'response'});
    }
}