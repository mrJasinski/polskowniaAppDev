package com.polskowniaApp.shop;

import com.polskowniaApp.utils.Category;
import com.polskowniaApp.utils.Level;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
class ShopInitializer implements ApplicationListener<ContextRefreshedEvent>
{
    private final ShopItemRepository shopItemRepo;

    ShopInitializer(final ShopItemRepository shopItemRepo)
    {
        this.shopItemRepo = shopItemRepo;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event)
    {
        var title1 = "Jeżyk polski";
        if (!this.shopItemRepo.existsByTitle(title1))
            this.shopItemRepo.save(new ShopItem(
                    title1
                    , 159.99
                    , "Przewodnik po grach słownych"
                    , "Przewodnik wprowadzający w arkana powszechncyh w języku polskim gier słownych"
                    , Category.EBOOK
                    , 0
                    , 0
                    , Level.A1
            ));

        var title2 = "kurs egzaminacyjny państwowy B2";
        if (!this.shopItemRepo.existsByTitle(title2))
            this.shopItemRepo.save(new ShopItem(
                    title2
                    , 1599.99
                    , "Przewodnik po grach słownych"
                    , "Przewodnik wprowadzający w arkana powszechncyh w języku polskim gier słownych"
                    , Category.EBOOK
                    , 0
                    , 0
                    , Level.A1
            ));
    }
}
