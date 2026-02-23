import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AppConstants } from "../../constans/app.constans";
import { ArticleReadModel } from "./articleRead.model";
import { Observable } from "rxjs";
import { Page } from "../../constans/page.interface";

@Injectable({providedIn: 'root'})
export class ArticleService
{
    articleLink : string;

    constructor(private http: HttpClient)
    {

    }

    getArticles() : Observable<Page<ArticleReadModel>>
    {
        return this.http.get<Page<ArticleReadModel>>(AppConstants.APP_URL + AppConstants.ARTICLES_URL);
    }

    getArticleByTitle(articleLink : string) : Observable<ArticleReadModel>
    {
        return this.http.get<ArticleReadModel>(AppConstants.APP_URL + AppConstants.ARTICLES_URL + "/" + articleLink);
    }

    getArticleLink()
    {
        return this.articleLink;
    }
}