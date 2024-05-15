import { Component } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../user';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatCardModule } from "@angular/material/card";
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { Token } from '../token';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterLink, CommonModule, FormsModule, MatButtonModule, MatFormFieldModule, MatInputModule, MatCardModule, MatIconModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  user: User = {
    email: "",
    password: ""
  };

  authenticated?: boolean;
  errorMessage: string = "";

  constructor(private loginService: LoginService) {}

  onSubmit(): void {
    let userToken: string = '';
    this.loginService.login(this.user).subscribe(token => console.log(token));
    //localStorage.setItem('token', userToken);
    console.log("userToken is " + userToken);
    //console.log("storage token is " + localStorage.getItem('token'));
  }

  loginError(error: HttpErrorResponse) {
    this.errorMessage = error.error;
    this.authenticated = false;
    return throwError(() => new Error());
  }
}