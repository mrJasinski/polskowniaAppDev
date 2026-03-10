package com.polskowniaApp.shop;

import com.polskowniaApp.utils.Category;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

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
    void wrapCategories_shouldReturnStringMadeOfCategoryNames()
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

//        TODO jakie testy można tu dać?


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

//    test pod kątem pustego i nulla oraz błędne dane wejściowe np ", Ebook"


//    List<Category> unwrapCategories(String categories)
//    {
//        if (categories == null || categories.isBlank())
//            return List.of();
//
//        return Arrays.stream(categories.split(","))
//                .map(String::trim)
//                .filter(s -> !s.isBlank())
//                .map(Category::getByName)
//                .toList();
//    }

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
    }

    @Test
    void unwrapCategories_shouldReturnEmptyListWhenCategoriesStringIsNull()
    {
//        given
        String categories = null;

//        system under test
        var toTest = new ShopItem();

//        when
        var result = toTest.unwrapCategories(categories);

//        then
        assertTrue(result.isEmpty());
    }

    @Test
    void unwrapCategories_shouldReturnEmptyListWhenCategoriesStringIsBlank()
    {
//        given
        var categories = "";

//        system under test
        var toTest = new ShopItem();

//        when
        var result = toTest.unwrapCategories(categories);

//        then
        assertTrue(result.isEmpty());
    }

    @Test
    void unwrapCategories_shouldReturnEmptyListWhenCategoriesStringIsWhitespace()
    {
//        given
        var categories = " ";

//        system under test
        var toTest = new ShopItem();

//        when
        var result = toTest.unwrapCategories(categories);

//        then
        assertTrue(result.isEmpty());
    }

    @Test
    void unwrapCategories_shouldReturnListWithSizeOfNumberOfDelimitersPlusOne()
    {
//        given
        var categories = Category.EBOOK + ShopItem.DELIMITER + " " + Category.AUDIOBOOK;
        var delimitersCount = StringUtils.countOccurrencesOf(categories, ShopItem.DELIMITER);

//        system under test
        var toTest = new ShopItem();

//        when
        var result = toTest.unwrapCategories(categories);

//        then
        assertEquals(delimitersCount + 1, result.size());
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