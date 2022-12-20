import { LoginComponent } from './pages/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { AddComponent } from './pages/admin/add/add.component';
import { EditComponent } from './pages/admin/edit/edit.component';
import { RegistroComponent } from './pages/registro/registro.component';
import { AdminGuard } from './service/admin.guard';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'registro',
    component: RegistroComponent,
    pathMatch: 'full'
  },
  {
    path:'admin',
    component:DashboardComponent,
    pathMatch: 'full',
    canActivate:[AdminGuard],
    children:[
      {
        path: '',
        component: DashboardComponent,
      },
      {
        path : 'add',
        component : AddComponent,
      },
      {
        path : 'cliente/:customerId',
        component : EditComponent,
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
