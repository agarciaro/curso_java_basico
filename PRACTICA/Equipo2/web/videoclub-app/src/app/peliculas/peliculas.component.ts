import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-peliculas',
  templateUrl: './peliculas.component.html',
  styleUrls: ['./peliculas.component.css']
})
export class PeliculasComponent implements OnInit {
  numbers=[1,2,3,4];
  usuario:String | null = "";
  constructor(private route:Router) { }

  ngOnInit(): void {
    this.usuario = localStorage.getItem("usuario");
    /*let value = localStorage.getItem("sesion"); 
    if(!value){
      
      this.route.navigate(["/"]);
    }*/
  }

  logout():void {
    //localStorage.removeItem("sesion");
  }

}
