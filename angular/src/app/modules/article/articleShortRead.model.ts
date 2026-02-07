export class ArticleShortReadModel
{
    constructor(
        public publishDate : Date
        , public title : String
        , public cycle : String
        , public author : String
        , public summary : String
        , public logo? : String
    )
    {
        
    }
}