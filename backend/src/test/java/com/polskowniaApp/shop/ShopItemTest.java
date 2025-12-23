package com.polskowniaApp.shop;

import com.polskowniaApp.utils.Category;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ShopItemTest
{

//    String wrapCategories(final Set<Category> categories)
//    {
//        var result = new StringBuilder();
//
//        for (Category category : categories)
//            result.append(", ").append(category);
//
//        return result.toString();
//    }

//    test of test ;)
    @Test
    void wrapCategories_shouldReturnString()
    {
//        given
        var categories = Set.of(Category.values());

//        system under test
        var toTest = new ShopItem();

//        when
        var result = toTest.wrapCategories(categories);

//        then
        System.out.println("xxxxx");
        System.out.println(result);


    }
}