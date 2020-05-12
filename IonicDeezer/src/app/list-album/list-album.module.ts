import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ListAlbumPageRoutingModule } from './list-album-routing.module';

import { ListAlbumPage } from './list-album.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ListAlbumPageRoutingModule
  ],
  declarations: [ListAlbumPage]
})
export class ListAlbumPageModule {}
