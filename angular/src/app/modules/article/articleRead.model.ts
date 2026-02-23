export class ArticleReadModel
{
    constructor(
        public publishDate : Date
        , public title : String
        , public link : string
        , public cycle : String
        , public author : String
        , public summary? : String
        , public text? : String
        , public logo? : String
    )
    {
        
    }
}