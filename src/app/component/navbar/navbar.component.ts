import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../service/login.service';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn$: Observable<boolean>;

  constructor(private loginService: LoginService) { }

  ngOnInit() {

  }

}
