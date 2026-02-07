import { NgFor } from "@angular/common";
import { Component } from "@angular/core";
import { ArticleService } from "../article.service";
import { ArticleShortReadModel } from "../articleShortRead.model";

@Component
({
  selector: 'articles',
  templateUrl: './articles.component.html'
  , imports: [NgFor]
})

export class ArticlesComponent 
{
    articles = new Array<ArticleShortReadModel>;

    constructor(private articleService : ArticleService)
      {
        
      }
    
      ngOnInit()
      {
        this.articleService.getArticles().subscribe( page => this.articles = page.content);
      }
}