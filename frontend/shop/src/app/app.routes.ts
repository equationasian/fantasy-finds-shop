import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { ClothingComponent } from './clothing/clothing.component';

export const routes: Routes = [
    { path: "", component: HomeComponent },
    { path: "login", component: LoginComponent },
    { path: "signup", component: SignupComponent },
    { path: "categories/clothing", component: ClothingComponent },
    { path: "categories/accessories", component: HomeComponent },
    { path: "categories/tools", component: HomeComponent },
    { path: "featured", component: HomeComponent },
    { path: "sale", component: HomeComponent },
    { path: "cart", component: HomeComponent }
];