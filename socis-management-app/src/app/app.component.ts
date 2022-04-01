import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Soci } from './soci';
import { SocisService } from './socis.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public title = 'Gestión de Socis';
  public socis: Soci[] = [];

  constructor(private socisService:SocisService){}

  ngOnInit(): void {
    this.getAllSocis();
  }

  public getAllSocis():void {
    this.socisService.getAllSocis().subscribe(
      (response: Soci[]) => {
        console.log(response);
        this.socis = response;
      },
      (error: HttpErrorResponse) => {
        console.error(error.message);
      }
    );
  }

}
