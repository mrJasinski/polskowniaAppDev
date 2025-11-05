import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./header/header.component";
import { AuthService } from './modules/auth/auth.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent 
{
  title = 'Polskownia';

  constructor(private authService: AuthService)
  {

  }

  ngOnInit() 
  {
    this.authService.autoLogin();
  }
}
