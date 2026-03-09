package com.polskowniaApp.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryUnitTest
{
//public static Category getByName(String name)
//    {
//        for(Category c : values())
//            if (c.getName().equalsIgnoreCase(name))
//                return c;
//
//        throw new NoSuchElementException("Category with given name not found!");
//    }

    @Test
    void getByName_shouldReturnEnumWhenFound()
    {
//        given
        var cat = "EBOOK";

//        when
        var result = Category.getByName(cat);

//        then
        assertEquals(Category.EBOOK, result);
    }
}