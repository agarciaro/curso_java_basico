import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private http:HttpClient) { }

  login(usuario:Usuario):Observable<any>{

    return this.http.post<Usuario>("http://localhost:8081/api/auth/login", usuario)
    
  }

  registro(usuario:Usuario):Observable<any>{

    return this.http.post<Usuario>("http://localhost:8081/api/auth/registro", usuario)
    
  }
}
