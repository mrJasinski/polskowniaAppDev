package com.polskowniaApp.utils;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
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
    void getByName_shouldReturnEnumWhenNameFound()
    {
//        given
        var name = "EBOOK";

//        when
        var result = Category.getByName(name);

//        then
        assertEquals(Category.EBOOK, result);
    }

    @Test
    void getByName_shouldThrowErrorWhenNameNotFound()
    {
//        given
        var name = "xxx";

//        when
        var result = catchThrowable(() -> Category.getByName(name));

//        then
        assertThat(result)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("Category with given name not found!");
    }
}