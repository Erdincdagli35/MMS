import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MessageListComponent } from '../app/components/message-list.component';

const routes: Routes = [
  { path: '', component: MessageListComponent } // İlk açılan sayfada mesajlar listelenecek
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
