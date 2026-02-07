package com.polskowniaApp.article;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ArticleController
{
    private final ArticleService articleService;

    ArticleController(final ArticleService articleService)
    {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    ResponseEntity<?> getArticles(@RequestParam(defaultValue = "0") int page)
    {
//        TODO wyciąganie listy artykułów + paginacja
        return ResponseEntity.ok(this.articleService.getAllArticlesByPageAsShortReadModel(page));
    }

    @GetMapping("/articles/{title}")
    ResponseEntity<?> getArticleByTitle(@PathVariable String title)
    {
//TODO przejście do konkretnego artykułu
//        odnośnikiem jest tytuł bez polskich znaków a słowa połączone myślnikami

        return ResponseEntity.ok(this.articleService.getArticleByTitleLinkAsReadModel(title));
    }
}
