import { ShopItemShort } from "./shopItemShort.model";

export class Shop
{
    constructor(
        public items : Array<ShopItemShort>
        , public categories : Array<String>
        , public levels : Array<String>
    )
    {

    }
}