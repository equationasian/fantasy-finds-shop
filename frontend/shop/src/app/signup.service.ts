import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  private signupUrl = "http://localhost:8080/api/register";

  constructor(private http: HttpClient) { }

  signup(user: User): Observable<boolean> {
    return this.http.post<boolean>(this.signupUrl, user);
  }
}
