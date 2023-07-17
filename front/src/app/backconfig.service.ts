import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class BackconfigService {
  constructor(private http: HttpClient) { }

  obterDadosDoBackend() {
    const url = 'http://localhost:8080/api/v1/';
    return this.http.get(url);
  }
}
