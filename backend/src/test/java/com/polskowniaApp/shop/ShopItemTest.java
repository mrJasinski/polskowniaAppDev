package com.polskowniaApp.shop;

import com.polskowniaApp.utils.Category;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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

//    tests of tests ;)
    @Test
    void wrapCategories_shouldReturnString()
    {
//        given
        var categories = List.of(Category.values());

//        system under test
        var toTest = new ShopItem();

//        when
        var result = toTest.wrapCategories(categories);

//        then
        System.out.println("xxxxx");
        System.out.println(result);


    }

    @Test
    void wrapCategories_shouldReturnStringWithOneWordWhenSingleCategoryIsProvided()
    {
//        given
        var categories = List.of(Category.EBOOK);

//        system under test
        var toTest = new ShopItem();

//        when
        var result = toTest.wrapCategories(categories);

//        then
        System.out.println("xxxxx");
        System.out.println(result);


    }

//    List<Category> unwrapCategories(final String categories)
//    {
//        var categoriesSplit = categories.split(", ");
//        var result = new ArrayList<Category>();
//
//        for (String c : categoriesSplit)
//        {
//            var cat = Category.getByName(c);
//            result.add(cat);
//        }
//
//        return result;
//    }

//    test pod kątem pustego i nulla oraz błędne dane wejściowe np ", Ebook"

    @Test
    void unwrapCategories_shouldConvertStringIntoListOfCategories()
    {
//        given
        var categoriesString = "EBOOK";

//        system under test
        var toTest = new ShopItem();

//        when
        var result = toTest.unwrapCategories(categoriesString);

//        then
        assertInstanceOf(List.class, result);
        System.out.println("result " + result);
    }

//    List<String> getCategoriesNames(List<Category> categories)
//    {
////        convert each category into it's name
////        to be used in ReadModel
//        return categories
//                .stream()
//                .map(Category::getName)
//                .toList();
//    }

    @Test
    void getCategoriesNames_shouldReturnListOfCategoryNames()
    {
//        given
        var categories = List.of(Category.EBOOK);

//        system under test
        var toTest = new ShopItem();

//        when
        var result = toTest.getCategoriesNames(categories);

//        then
        assertInstanceOf(List.class, result);
        System.out.println("result " + result.get(0));
    }


}