package com.polskowniaApp.shop;

import com.polskowniaApp.shop.dto.ShopItemShortReadModel;
import com.polskowniaApp.utils.Category;
import com.polskowniaApp.utils.Level;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shop_items")
public class ShopItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String refNumber;
    private String title;
    private double price;
    private String descriptionShort;
    private String descriptionFull;
    private int lessonsAmount;         //lessons amount
    private int lessonDuration;       //lesson duration (eg 45 min )
//    czas trwania np audiobooka, ilość lekcji w wideo/audio kursie
    @Enumerated(EnumType.STRING)
    private Level level;
    private String fileReference;
    private String logoReference;
    private String categories;

    ShopItem()
    {
    }

    ShopItem(
            final String title
            , final double price
            , final String descriptionShort
            , final String descriptionFull
            , final Set<Category> categories
            , final int lessonsAmount
            , final int lessonDuration
            , final Level level)
    {
        this.refNumber = generateRefNumber(getCategoriesAcronyms(categories), level.name());
        this.title = title;
        this.price = price;
        this.descriptionShort = descriptionShort;
        this.descriptionFull = descriptionFull;
        this.categories = wrapCategories(categories);
        this.lessonsAmount = lessonsAmount;
        this.lessonDuration = lessonDuration;
        this.level = level;
    }

    String generateRefNumber(final String acronym, final String level)
    {
        var dt = LocalDateTime.now();
        var timestamp = String.format("%s%s%s%s%s%s%s", dt.getYear(), dt.getMonthValue(), dt.getDayOfMonth(), dt.getHour(), dt.getMinute(), dt.getSecond(), dt.getNano());

        return level + "_" + acronym + "_" + timestamp;
    }

    String getCategoriesAcronyms(Set<Category> categories)
    {
//        convert each category acronym into one string
//        to be used in shop item reference number

        var result = new StringBuilder();

        for (Category c : categories)
            result.append(c.getAcronym());

        return result.toString();
    }

    List<String> getCategoriesNames(List<Category> categories)
    {
//        convert each category into it's name
//        to be used in ReadModel
        return categories
                .stream()
                .map(Category::getName)
                .toList();
    }

    String wrapCategories(final Set<Category> categories)
    {
        var result = new StringBuilder();

        for (Category c : categories)
            result.append(", ").append(c.getName());

        return result.toString();
    }

    List<Category> unwrapCategories(final String categories)
    {
        var categoriesSplit = categories.split(", ");
        var result = new ArrayList<Category>();

        for (String c : categoriesSplit)
        {
            var cat = Category.getByName(c);
            result.add(cat);
        }

        return result;
    }

    List<String> unwrapCategoriesNames(final String categories)
    {
        var categoriesSplit = categories.split(", ");

        return List.of(categoriesSplit);
    }

    //    ShortReadModel is used on main shop page and has only some item details eg short description etc
    ShopItemShortReadModel toShortReadModel()
    {
        return new ShopItemShortReadModel(
                this.title
                , this.price
                , this.descriptionShort
                , getCategoriesNames(unwrapCategories(this.categories))
                , this.lessonsAmount
                , this.lessonDuration
                , this.level.name()
        );
    }
}
