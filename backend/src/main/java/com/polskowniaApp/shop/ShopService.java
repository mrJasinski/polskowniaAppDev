package com.polskowniaApp.shop;

import com.polskowniaApp.shop.dto.ShopDTO;
import com.polskowniaApp.shop.dto.ShopItemShortReadModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ShopService
{
    private final ShopItemRepository shopItemRepo;

    ShopService(final ShopItemRepository shopItemRepo)
    {
        this.shopItemRepo = shopItemRepo;
    }

    ShopDTO getShopAsDto()
    {
        var items = getShopItemsAsShortReadModel();

        return new ShopDTO(items);
    }

    List<ShopItemShortReadModel> getShopItemsAsShortReadModel()
    {
       return  this.shopItemRepo.findAll()
               .stream()
               .map(ShopItem::toShortReadModel)
               .toList();
    }

//    WAŻNE idempotency
}
