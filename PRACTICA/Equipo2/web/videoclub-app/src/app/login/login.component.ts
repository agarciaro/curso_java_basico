import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl } from '@angular/forms';

import { Usuario } from '../model/usuario';
import { UsuariosService } from '../service/usuarios.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  

  title:String="";
  active:boolean=false;

  //Variables del formulario
  codInvitacion=new FormControl('');
  username=new FormControl('');
  password=new FormControl('');
  passw2=new FormControl('');
  codReferido=new FormControl('');

   
 
   
  constructor(private route:Router, private usuarioService:UsuariosService) {
   }
  
  ngOnInit(): void {
    this.title="Login"
    this.active=false;
  }
  

  onLogin(){

    let usuario:Usuario={
      username:this.username.value,
      password:this.password.value
    }
    this.usuarioService.login(usuario).subscribe(
      respuesta => {localStorage.setItem("token", respuesta.token);
      localStorage.setItem("usuario", respuesta.username)}
      
    );
    this.route.navigate(["/peliculas"]);
    
  }

  onRegister(){
    let usuario:Usuario={
      codInv:this.codInvitacion.value,
      username:this.username.value,
      password:this.password.value,
      codRef:this.codReferido.value
    }
    console.log(usuario);
    this.usuarioService.registro(usuario).subscribe(
      response => console.log(response)
    );
    this.title = "Login";
  }
  registro(){
    
    this.title = "Registro";
  }
  
}
