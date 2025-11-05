package com.polskowniaApp.shop.dto;

import com.polskowniaApp.utils.Category;
import com.polskowniaApp.utils.Level;

import java.util.Arrays;
import java.util.List;

public class ShopDTO
{
    private List<ShopItemShortReadModel> items;
    private List<String> categories;
    private List<String> levels;

    ShopDTO()
    {
    }

    public ShopDTO(final List<ShopItemShortReadModel> items)
    {
        this.items = items;
        this.categories = Arrays.stream(Category.values())
                .map(Category::getName)
                .toList();
        this.levels = Arrays.stream(Level.values())
                .map(Level::toString)
                .toList();
    }

    public List<ShopItemShortReadModel> getItems()
    {
        return this.items;
    }

    public List<String> getCategories()
    {
        return this.categories;
    }

    public List<String> getLevels()
    {
        return this.levels;
    }
}
