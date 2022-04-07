import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardPeliculaComponent } from './card-pelicula.component';

describe('CardPeliculaComponent', () => {
  let component: CardPeliculaComponent;
  let fixture: ComponentFixture<CardPeliculaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardPeliculaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CardPeliculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
