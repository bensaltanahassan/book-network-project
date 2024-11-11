import { HttpHeaders, HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { TokenService } from '../token/token.service';

export const httpTokenInterceptor: HttpInterceptorFn = (req, next) => {
  const tokenService = inject(TokenService);
  console.log(tokenService.token);
  if (tokenService.token) {
    const authReq = req.clone({
      headers: new HttpHeaders({
        Authorization: `Bearer ${tokenService.token}`,
      }),
    });
    return next(authReq);
  }
  return next(req);
};
