package com.polskowniaApp.article;

import com.polskowniaApp.article.dto.ArticleReadModel;
import com.polskowniaApp.article.dto.ArticleShortReadModel;
import jakarta.persistence.*;

import java.text.Normalizer;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
class Article
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String articleLink;
    private String articleCycle;
    private LocalDateTime publishDate;
    private String author;
    private String summary;
    private String fileReference;
    private String logoReference;

    Article()
    {
    }

    Article(
            final String title
            , final String articleCycle
            , final LocalDateTime publishDate
            , final String author
            , final String summary
            , final String fileReference
            , final String logoReference)
    {
        this.title = title;
        this.articleLink = covertTitleToLink(title);
        this.articleCycle = articleCycle;
        this.publishDate = publishDate;
        this.author = author;
        this.summary = summary;
        this.fileReference = fileReference;
        this.logoReference = logoReference;
    }

    Article(final String title, final String articleLink, final String articleCycle, final LocalDateTime publishDate, final String author, final String summary, final String fileReference, final String logoReference)
    {
        this(title, articleCycle, publishDate, author, summary, fileReference, logoReference);
        this.articleLink = articleLink;
    }

    public int getId()
    {
        return this.id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getArticleLink()
    {
        return this.articleLink;
    }

    public String getArticleCycle()
    {
        return this.articleCycle;
    }

    public LocalDateTime getPublishDate()
    {
        return this.publishDate;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getSummary()
    {
        return this.summary;
    }

    public String getFileReference()
    {
        return fileReference;
    }

    public String getLogoReference()
    {
        return logoReference;
    }

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
            this.publishDate
            , this.articleCycle
            , this.title
            , this.author
            , this.summary
        );
    }

    ArticleReadModel toReadModel()
    {
        return new ArticleReadModel(
//                TODO
        );
    }
}
