package com.polskowniaApp.article;

import com.polskowniaApp.article.dto.ArticleReadModel;
import com.polskowniaApp.article.dto.ArticleShortReadModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
class ArticleService
{
    private final ArticleRepository articleRepo;

    ArticleService(final ArticleRepository articleRepo)
    {
        this.articleRepo = articleRepo;
    }

    Page<Article> getAllArticlesByPage(final int page)
    {
//        amount of articles on page
        var ARTICLES_AMOUNT = 10;
        var pageWithArticles = PageRequest.of(page, ARTICLES_AMOUNT);

        return this.articleRepo.findAll(pageWithArticles);
    }
//TODO konwersja na później
//    Page<ArticleShortReadModel> getAllArticlesByPageAsShortReadModel(final int page)
//    {
//        return getAllArticlesByPage(page)
//                .stream()
//                .map(Article::toShortReadModel)
//                .toList();
//    }

    Article getArticleByTitleLink(final String title)
    {
        return this.articleRepo.findByLink(title)
                .orElseThrow(() -> new NoSuchElementException("Article with given link title not found!"));
    }

    ArticleReadModel getArticleByTitleLinkAsReadModel(final String title)
    {
        return getArticleByTitleLink(title).toReadModel();
    }
}
