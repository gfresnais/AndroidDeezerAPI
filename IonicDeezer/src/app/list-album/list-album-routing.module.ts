import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListAlbumPage } from './list-album.page';

const routes: Routes = [
  {
    path: '',
    component: ListAlbumPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ListAlbumPageRoutingModule {}
