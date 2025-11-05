package com.polskowniaApp.shop;

import com.polskowniaApp.shop.dto.ShopItemShortReadModel;
import com.polskowniaApp.utils.Category;
import com.polskowniaApp.utils.Level;
import jakarta.persistence.*;

import java.time.LocalDateTime;

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
    @Enumerated(EnumType.STRING)
    private Category category;
    private int lessonsAmount;         //lessons amount
    private int lessonDuration;       //lesson duration (eg 45 min )
    @Enumerated(EnumType.STRING)
    private Level level;
    private String fileReference;
    private String logoReference;

    ShopItem()
    {
    }

    ShopItem(final String title, final double price, final String descriptionShort, final String descriptionFull, final Category category, final int lessonsAmount, final int lessonDuration, final Level level)
    {
        this.refNumber = generateRefNumber(category.getAcronym(), level.name());
        this.title = title;
        this.price = price;
        this.descriptionShort = descriptionShort;
        this.descriptionFull = descriptionFull;
        this.category = category;
        this.lessonsAmount = lessonsAmount;
        this.lessonDuration = lessonDuration;
        this.level = level;
    }

    String generateRefNumber(final String acronym, final String level)
    {
        var dt = LocalDateTime.now();
        var timestamp = String.format("%s%s%s%s%s%s%s", dt.getYear(), dt.getMonthValue(), dt.getDayOfMonth(), dt.getHour(), dt.getMinute(), dt.getSecond(), dt.getNano());

        return acronym + "_" + level + "_" + timestamp;
    }

    //    ShortReadModel is used on main shop page and has only some item details eg short description etc
    ShopItemShortReadModel toShortReadModel()
    {
        return new ShopItemShortReadModel(
                this.title
                , this.price
                , this.descriptionShort
                , this.category.getName()
                , this.lessonsAmount
                , this.lessonDuration
                , this.level.name()
        );
    }
}
