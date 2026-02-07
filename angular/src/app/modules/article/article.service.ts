import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AppConstants } from "../../constans/app.constans";
import { ArticleShortReadModel } from "./articleShortRead.model";
import { Observable } from "rxjs";
import { Page } from "../../constans/paget.interface";

@Injectable({providedIn: 'root'})
export class ArticleService
{
    constructor(private http: HttpClient)
    {

    }

    getArticles() : Observable<Page<ArticleShortReadModel>>
    {
        // return this.http.get<Page<ArticleShortReadModel>>(AppConstants.APP_URL + AppConstants.ARTICLES_URL, { observe : 'response'});
        return this.http.get<Page<ArticleShortReadModel>>(AppConstants.APP_URL + AppConstants.ARTICLES_URL);
    }
}