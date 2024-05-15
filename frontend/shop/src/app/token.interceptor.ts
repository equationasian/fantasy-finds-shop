import { HttpInterceptorFn } from '@angular/common/http';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  const tokenObject = localStorage.getItem('token');
  if (tokenObject != null) {
    //const token = JSON.parse(tokenObject);

    //console.log(tokenObject);
    const authReq = req.clone({
      setHeaders: {
        //Authorization: `Bearer ${token}`
      }
    });

    return next(authReq);
  }
  
  return next(req);
};