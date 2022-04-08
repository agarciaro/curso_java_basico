import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-card-pelicula',
  templateUrl: './card-pelicula.component.html',
  styleUrls: ['./card-pelicula.component.css']
})
export class CardPeliculaComponent implements OnInit {
@Input() number!:string;
  constructor() { }

  ngOnInit(): void {
  }

}
