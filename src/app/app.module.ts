// <==========Modules Imports==============>
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';

// <==========Material Imports==============>
import {MatButtonModule, MatCheckboxModule, MatGridList} from '@angular/material';
import { MatInputModule } from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';


// <==========Component Imports==============>
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { AppRoutingModule } from './/app-routing.module';
import { HomeComponent } from './component/home/home.component';
import { TopicDetailComponent } from './component/topic-detail/topic-detail.component';
import { NavbarComponent } from './component/navbar/navbar.component';

// <==========Services Imports==============>
import { LoginService } from './service/login.service';
import { TopiccardComponent } from './component/topiccard/topiccard.component';
import { QuerycardComponent } from './component/querycard/querycard.component';
import { AnswerComponent } from './component/answer/answer.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    TopicDetailComponent,
    NavbarComponent,
    TopiccardComponent,
    QuerycardComponent,
    AnswerComponent
  ],
  imports: [
    BrowserModule,
    FlexLayoutModule,
    MatButtonModule,
    MatCheckboxModule,
    MatInputModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatIconModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    MatMenuModule,
    MatPaginatorModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
