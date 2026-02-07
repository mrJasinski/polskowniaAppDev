package com.polskowniaApp.article.dto;

import java.time.LocalDateTime;

public class ArticleShortReadModel
{
    private LocalDateTime publishDate;
    private String title;
    private String cycle;    //cykl artykułów lepsza nazwa?
    private String author;
    private String summary;
    private byte[] logo;

    public ArticleShortReadModel()
    {
    }

    public ArticleShortReadModel(final LocalDateTime publishDate, final String cycle, final String title, final String author, final String summary)
    {
        this.publishDate = publishDate;
        this.cycle = cycle;
        this.title = title;
        this.author = author;
        this.summary = summary;
    }

    public LocalDateTime getPublishDate()
    {
        return this.publishDate;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getCycle()
    {
        return this.cycle;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getSummary()
    {
        return this.summary;
    }

    public byte[] getLogo()
    {
        return this.logo;
    }
}
