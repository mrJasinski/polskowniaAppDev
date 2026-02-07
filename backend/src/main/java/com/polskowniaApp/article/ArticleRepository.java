package com.polskowniaApp.article;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

interface ArticleRepository
{
    Page<Article> findAll(final Pageable pageable);

    Article save(final Article toSave);

    Optional<Article> findByArticleLink(final String title);

    boolean existsByArticleLink(final  String link);
}
