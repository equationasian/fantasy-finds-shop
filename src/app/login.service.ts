import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginUrl = "http://localhost:8080/api/login";

  constructor(private http: HttpClient) { }

  login(user: User): Observable<boolean> {
    return this.http.post<boolean>(this.loginUrl, user);
  }
}
