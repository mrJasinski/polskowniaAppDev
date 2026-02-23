package com.polskowniaApp.article;

import com.polskowniaApp.article.dto.ArticleWriteModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
class ArticleController
{
    private final ArticleService articleService;

    ArticleController(final ArticleService articleService)
    {
        this.articleService = articleService;
    }

    @GetMapping()
    ResponseEntity<?> getArticles(@RequestParam(defaultValue = "0") int page)
    {
//        TODO wyciąganie listy opublikowanych artykułów + paginacja
        return ResponseEntity.ok(this.articleService.getAllPublishedArticlesByPageAsShortReadModel(page));
    }

    @GetMapping("/{title}")
    ResponseEntity<?> getArticleByTitle(@PathVariable String title)
    {
        return ResponseEntity.ok(this.articleService.getArticleByTitleLinkAsReadModel(title));
    }

    @PostMapping("/add")
    ResponseEntity<?> addArticle(@RequestBody ArticleWriteModel toSave)
    {
        return ResponseEntity.ok(this.articleService.saveArticle(toSave));
    }
}
