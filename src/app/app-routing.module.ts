import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { HomeComponent } from './component/home/home.component';
import { TopicDetailComponent } from './component/topic-detail/topic-detail.component';
import { AnswerComponent } from './component/answer/answer.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent},
  { path: 'topic-details', component: TopicDetailComponent},
  { path: 'answer', component: AnswerComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({

  imports: [
    RouterModule.forRoot(routes)
  ],

  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
