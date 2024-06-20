import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { AppComponent } from './app/app.component';
import { appConfig } from './app/app.config';
import { appRouterProviders, routes } from './app/app.routes';
import { AdminAuthGuardComponent } from './app/admin-auth-guard/admin-auth-guard.component';
import { StorageService } from './app/storage.service';
import { HttpRequestInterceptor } from './app/interceptor/http.interceptor'; 

const httpInterceptorProviders = {
  provide: HTTP_INTERCEPTORS,
  useClass: HttpRequestInterceptor,
  multi: true
};

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(),
    provideRouter(routes),
    appRouterProviders,
    AdminAuthGuardComponent, 
    StorageService,
    httpInterceptorProviders,
    ...appConfig.providers,
  ]
}).catch(err => console.error(err));