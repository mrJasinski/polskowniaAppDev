package com.polskowniaApp.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlShopItemRepository extends ShopItemRepository, JpaRepository<ShopItem, Integer>
{

}
