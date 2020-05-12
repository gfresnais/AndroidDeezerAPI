import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ListTrackPageRoutingModule } from './list-track-routing.module';

import { ListTrackPage } from './list-track.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ListTrackPageRoutingModule
  ],
  declarations: [ListTrackPage]
})
export class ListTrackPageModule {}
