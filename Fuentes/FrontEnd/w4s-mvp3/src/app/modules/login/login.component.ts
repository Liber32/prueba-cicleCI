import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email:String;

  constructor
  (
    private LoginService: LoginService,
    private router: Router
  ) {
    this.email = "";
   }

  ngOnInit() {
  }

  

}
