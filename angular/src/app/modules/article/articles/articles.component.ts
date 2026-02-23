import { NgFor } from "@angular/common";
import { Component } from "@angular/core";
import { ArticleService } from "../article.service";
import { ArticleReadModel } from "../articleRead.model";
import { Router } from "@angular/router";
import { AppConstants } from "../../../constans/app.constans";

@Component
({
  selector: 'articles',
  templateUrl: './articles.component.html'
  , imports: [NgFor]
})

export class ArticlesComponent 
{
    articles = new Array<ArticleReadModel>;

    constructor(private articleService : ArticleService, private router : Router)
      {
        
      }
    
      ngOnInit()
      {
        this.articleService.getArticles().subscribe( page => this.articles = page.content);
      }

      onGoToArticle(articleLink : string)
      {
        this.articleService.articleLink = articleLink;

        this.router.navigate([AppConstants.ARTICLES_URL + "/" + articleLink]);
      }
}