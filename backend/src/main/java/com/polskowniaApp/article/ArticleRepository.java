package com.polskowniaApp.article;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

interface ArticleRepository
{
    Page<Article> findAll(Pageable pageable);

    Optional<Article> findByLink(final String title);
}
