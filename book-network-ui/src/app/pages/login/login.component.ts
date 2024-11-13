import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationRequest } from '../../services/models';
import { AuthenticationService } from '../../services/services';
import { TokenService } from '../../services/token/token.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  router: Router = inject(Router);
  authService: AuthenticationService = inject(AuthenticationService);
  tokenService: TokenService = inject(TokenService);

  authRequest: AuthenticationRequest = {
    email: '',
    password: '',
  };
  errorMsg: string[] = [];

  register() {
    this.router.navigate(['register']);
  }
  login() {
    console.log(this.authRequest);
    this.errorMsg = [];
    this.authService
      .authenticate({
        body: this.authRequest,
      })
      .subscribe({
        next: (data) => {
          console.log(data);
          // save the token
          this.tokenService.token = data.token as string;
          this.router.navigate(['books']);
        },
        error: (err) => {
          console.log(err);
          if (err.error.validationErrors) {
            this.errorMsg = err.error.validationErrors;
          } else {
            this.errorMsg.push(err.error.businessErrorDescription);
          }
        },
      });
  }
}
