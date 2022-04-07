import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { VideoClubComponent } from './videoclub-login/videoclub-login.component';
import { VideoClubRegsiterComponent } from './videoclub-register/videoclub-register.component';

@NgModule({
  declarations: [
    AppComponent,
    VideoClubComponent,
    VideoClubRegsiterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
