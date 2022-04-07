import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Soci } from './soci';

@Injectable({
  providedIn: 'root'
})
export class SocisService {

  private apiBaseUrl = environment.apiBaseUrl;


  constructor(private http: HttpClient) {}

  public getAllSocis(): Observable<Soci[]> {
    return this.http.get<Soci[]>(`${this.apiBaseUrl}/socis`);
  }

  public getSociByCodi(codi: number): Observable<Soci> {
    return this.http.get<Soci>(`${this.apiBaseUrl}/socis/${codi}`);
  }

  public insertSoci(soci: Soci): Observable<Soci> {
    return this.http.post<Soci>(`${this.apiBaseUrl}/socis`, soci);
  }

  public updateSoci(soci: Soci): Observable<Soci> {
    return this.http.put<Soci>(`${this.apiBaseUrl}/socis/${soci.codi}`, soci);
  }

  public deleteSoci(codi: number): Observable<void> {
    return this.http.delete<void>(`${this.apiBaseUrl}/socis/${codi}`);
  }

}
