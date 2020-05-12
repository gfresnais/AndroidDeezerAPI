import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListTrackPage } from './list-track.page';

const routes: Routes = [
  {
    path: '',
    component: ListTrackPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ListTrackPageRoutingModule {}
