package com.polskowniaApp.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlShopItemRepository extends ShopItemRepository, JpaRepository<ShopItem, Integer>
{

}
