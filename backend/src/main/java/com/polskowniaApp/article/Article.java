package com.polskowniaApp.article;

import com.polskowniaApp.article.dto.ArticleReadModel;
import com.polskowniaApp.article.dto.ArticleShortReadModel;
import jakarta.persistence.*;

import java.text.Normalizer;
import java.util.regex.Pattern;

@Entity
@Table(name = "articles")
class Article
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String articleLink;
    private String title;
    private String articleCycle;
    private String author;
    private String summary;
    private String fileReference;


    String covertTitleToLink(final String title)
    {
        if (title == null)
//            TODO czy tu raczej powinien być błąd?
            return null;

        var text = title.replaceAll(" ", "-");

        var normalized = Normalizer.normalize(text, Normalizer.Form.NFD);

        var result = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

//        ponieważ normalizer nie zawsze poprawnie usuwa ł/Ł
        result = result.replace("ł", "l").replace("Ł", "L");

        return result.toLowerCase();
    }

    ArticleShortReadModel toShortReadModel()
    {
        return new ArticleShortReadModel(
//                TODO
        );
    }

    ArticleReadModel toReadModel()
    {
        return new ArticleReadModel(
//                TODO
        );
    }
}
