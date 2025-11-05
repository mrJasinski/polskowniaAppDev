import { Component, OnInit } from "@angular/core";

@Component({
    selector: 'dashboard',
    templateUrl: './dashboard.component.html'
    ,imports: []
})
export class DashboardComponent implements OnInit
{
    constructor()
    {
        //dodać auth service i getLogged User żeby uzyskać imię i rolę
    }

    ngOnInit()
    {
        
    }
}