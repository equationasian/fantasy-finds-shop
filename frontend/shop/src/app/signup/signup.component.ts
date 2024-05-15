import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { RouterLink } from '@angular/router';
import { User } from '../user';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [RouterLink, CommonModule, FormsModule, MatButtonModule, MatIconModule, MatCardModule, MatFormFieldModule, MatInputModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  user: User = {
    email: "",
    password: ""
  };

  isSuccess?: boolean;

  constructor(private signupService: SignupService) {}

  onSubmit(): void {
    this.signupService.signup(this.user).subscribe(success => this.isSuccess = success);
  }
}
