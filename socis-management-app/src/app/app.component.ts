import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Soci } from './soci';
import { SocisService } from './socis.service';

@Component({
  selector: 'socis-app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public title = 'Gestión de Socis';
  public socis: Soci[] = [];
  public deleteSoci: Soci;

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

  public searchSocis(key: string):void {
    const results: Soci[] = [];
    for(const soci of this.socis){
      if(soci.nom.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || soci.cognom.toLowerCase().indexOf(key.toLowerCase()) !== -1){
        results.push(soci);
      }
    }
    this.socis = results;

      if(results.length === 0 || !key) {
        this.getAllSocis();
      }
  }

  public onDeleteSoci(codi: number):void {
    this.socisService.deleteSoci(codi).subscribe(
      (response: void) => {
        this.getAllSocis();
      },
      (error: HttpErrorResponse) => {
        console.error(error.message);
      }
    );
  }

  public onOpenModal(soci: Soci, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if(mode === 'delete') {
      this.deleteSoci = soci;
      button.setAttribute('data-target', '#deleteSociModal');
    }

    container.appendChild(button);
    button.click();
  }

}
