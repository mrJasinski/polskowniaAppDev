package com.polskowniaApp.article.dto;

import java.time.LocalDateTime;

public class ArticleShortReadModel
{
    private LocalDateTime publishDate;
    private String cycle;    //cykl artykułów lepsza nazwa?
    private String title;
    private String author;
    private String summary;
//    TODO
//    obrazek?


    public ArticleShortReadModel()
    {
    }

    ArticleShortReadModel(final LocalDateTime publishDate, final String cycle, final String title, final String author, final String summary)
    {
        this.publishDate = publishDate;
        this.cycle = cycle;
        this.title = title;
        this.author = author;
        this.summary = summary;
    }
}
