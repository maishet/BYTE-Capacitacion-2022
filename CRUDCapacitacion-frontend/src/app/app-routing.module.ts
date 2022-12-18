import { LoginComponent } from './pages/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/customer/dashboard/dashboard.component';
import { AddComponent } from './pages/customer/add/add.component';
import { EditComponent } from './pages/customer/edit/edit.component';

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
    path:'customers',
    component:DashboardComponent,
    //canActivate:[AdminGuard],
    children:[
      {
        path : 'add',
        component : AddComponent
      },
      {
        path : 'edit',
        component : EditComponent
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
