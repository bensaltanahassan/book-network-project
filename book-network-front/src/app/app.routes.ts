import { Routes } from '@angular/router';
import { ActivateAccountComponent } from './pages/activate-account/activate-account.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { authGuard } from './services/guard/auth.guard';

export const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'activate-account',
    component: ActivateAccountComponent,
  },
  {
    path: 'books',
    loadChildren: () =>
      import('./modules/book/book.module').then((m) => m.BookModule),
    canActivate: [authGuard],
  },
];
