package com.polskowniaApp.shop.dto;

import java.util.List;
import java.util.Set;

public class ShopItemShortReadModel
{
    private String title;
    private double price;
    private String descriptionShort;
    private List<String> categories;
    private int lessonsAmount;         //lessons amount
    private int lessonDuration;       //lesson duration (eg 45 min )
    private String level;

    ShopItemShortReadModel()
    {
    }

    public ShopItemShortReadModel(
            final String title
            , final double price
            , final String descriptionShort
            , final List<String> categories
            , final int lessonsAmount
            , final int lessonDuration
            , final String level)
    {
        this.title = title;
        this.price = price;
        this.descriptionShort = descriptionShort;
        this.categories = categories;
        this.lessonsAmount = lessonsAmount;
        this.lessonDuration = lessonDuration;
        this.level = level;
    }

    public String getTitle()
    {
        return this.title;
    }

    public double getPrice()
    {
        return this.price;
    }

    public String getDescriptionShort()
    {
        return this.descriptionShort;
    }

    public List<String> getCategories()
    {
        return this.categories;
    }

    public int getLessonsAmount()
    {
        return this.lessonsAmount;
    }

    public int getLessonDuration()
    {
        return this.lessonDuration;
    }

    public String getLevel()
    {
        return this.level;
    }
}
