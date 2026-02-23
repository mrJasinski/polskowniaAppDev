package com.polskowniaApp.article;

import com.polskowniaApp.article.dto.ArticleReadModel;
import com.polskowniaApp.article.dto.ArticleShortReadModel;
import com.polskowniaApp.article.dto.ArticleWriteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
class ArticleService
{
    private final ArticleRepository articleRepo;

    ArticleService(final ArticleRepository articleRepo)
    {
        this.articleRepo = articleRepo;
    }

    Page<Article> getAllPublishedArticlesByPage(final int page)
    {
//        amount of articles on page
        var ARTICLES_AMOUNT = 10;
        var pageWithArticles = PageRequest.of(page, ARTICLES_AMOUNT);

        var timestamp = LocalDateTime.now();

        return this.articleRepo.findAllPublished(pageWithArticles, timestamp);
    }

    Page<ArticleShortReadModel> getAllPublishedArticlesByPageAsShortReadModel(final int page)
    {
        return getAllPublishedArticlesByPage(page)
                .map(Article::toShortReadModel);

    }

    Article getArticleByTitleLink(final String title)
    {
        return this.articleRepo.findByArticleLink(title)
                .orElseThrow(() -> new NoSuchElementException("Article with given link title not found!"));
    }

    ArticleReadModel getArticleByTitleLinkAsReadModel(final String title)
    {
        return getArticleByTitleLink(title).toReadModel();
    }

    Article saveArticle(final ArticleWriteModel toSave)
    {
        return this.articleRepo.save(new Article(
                toSave.getTitle()
                , toSave.getArticleCycle()
                , toSave.getPublishDate()
                , toSave.getAuthor()
                , toSave.getSummary()
                , toSave.getArticleText()
//                TODO
                , null
        ));
    }
}
