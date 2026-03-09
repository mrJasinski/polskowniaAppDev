package com.polskowniaApp.shop;

import com.polskowniaApp.utils.Category;
import com.polskowniaApp.utils.Level;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ShopItemRepositoryUnitTest
{
    @Test
    void findAll_shouldReturnAllShopItems()
    {
//        given
        var item1 = new ShopItem(
                "Lorem ipsum"
                , 345.66
                , "lorem ipsum etc"
                , "lorem ipsum coś tam dalej itd"
                , List.of(Category.EBOOK)
                , 0
                , 0
                , Level.A1);

        var mockShopItemRepo = mock(ShopItemRepository.class);
        given(mockShopItemRepo.findAll()).willReturn(List.of(item1));

//        when
        var result = mockShopItemRepo.findAll();

//        then
        System.out.println("results");
        for (ShopItem s : result)
            System.out.println(s.getTitle() + " CAT |" + s.getCategories());
    }


}
