package com.polskowniaApp.article.dto;

import java.time.LocalDateTime;

public class ArticleWriteModel
{

//        private int id;
//    private String title;
//    private String articleLink;
//    private String articleCycle;
//    private LocalDateTime publishDate;
//    private String author;
//    private String summary;
//    private String articleText;
//    private String logoReference;

    private String title;
    private String articleCycle;
    private LocalDateTime publishDate;
    private String author;
    private String summary;
    private String articleText;
//    logo reference


    ArticleWriteModel()
    {
    }

    ArticleWriteModel(final String title, final String articleCycle, final LocalDateTime publishDate, final String author, final String summary, final String articleText)
    {
        this.title = title;
        this.articleCycle = articleCycle;
        this.publishDate = publishDate;
        this.author = author;
        this.summary = summary;
        this.articleText = articleText;
    }

    public String getTitle()
    {
        return this.title;
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

    public String getArticleText()
    {
        return this.articleText;
    }
}
