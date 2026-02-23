import { Component } from "@angular/core";
import { ArticleService } from "./article.service";
import { ArticleReadModel } from "./articleRead.model";

@Component
({
  selector: 'article',
  templateUrl: './article.component.html'
  , imports: []
})

export class ArticleComponent 
{
    article : ArticleReadModel;

    constructor(private articleService : ArticleService)
      {
        
      }
    
      ngOnInit()
      {
        this.articleService.getArticleByTitle(this.articleService.getArticleLink()).subscribe( response => this.article = response);
      }
}