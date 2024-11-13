import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CodeInputModule } from 'angular-code-input';
import { AuthenticationService } from '../../services/services';

@Component({
  selector: 'app-activate-account',
  standalone: true,
  imports: [FormsModule, CommonModule, CodeInputModule],
  templateUrl: './activate-account.component.html',
  styleUrl: './activate-account.component.scss',
})
export class ActivateAccountComponent {
  private router: Router = inject(Router);
  private authService: AuthenticationService = inject(AuthenticationService);

  message: string = '';
  isOkay: boolean = false;
  submitted: boolean = false;

  onCodeCompleted(code: string) {
    this.confirmAccount(code);
  }
  confirmAccount(code: string) {
    this.authService.activateAccount({ token: code }).subscribe({
      next: (data) => {
        console.log(data);
        this.message =
          'Your account has been successfully activated.\nPlease login.';
        this.isOkay = true;
        this.submitted = true;
      },
      error: (err) => {
        console.log(err);
        this.message = "The code you've entered is invalid or expired.";
        this.submitted = true;
        this.isOkay = false;
      },
    });
  }
  redirectToLogin() {
    this.router.navigate(['login']);
  }
}
