package com.polskowniaApp.shop;

import java.util.List;

interface ShopItemRepository
{
    List<ShopItem> findAll();

    ShopItem save(final ShopItem toSave);

    boolean existsByTitle(final String title1);
}
