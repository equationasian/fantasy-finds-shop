import { Component } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../user';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatCardModule } from "@angular/material/card";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, MatButtonModule, MatFormFieldModule, MatInputModule, MatCardModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  user: User = {
    email: "",
    password: ""
  };

  isSuccess?: boolean;

  constructor(private loginService: LoginService) {}

  onSubmit(): void {
    this.loginService.login(this.user).subscribe(success => this.isSuccess = success);
  }
}
