import { Component, OnInit } from '@angular/core';
import { Track, DeezerService } from '../service/deezer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-list-track',
  templateUrl: './list-track.page.html',
  styleUrls: ['./list-track.page.scss'],
})
export class ListTrackPage implements OnInit {
  TAG: string = "ListTrackPage";

  listTracks: Track[];

  id: number;

  constructor(public deezerService: DeezerService, public router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.id = Number.parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    console.log(`${this.TAG} initListTrackPage = ${this.id}`);
    this.searchTracks();
  }

  searchTracks() {
    this.deezerService.getTracks(this.id).then( result => {
      console.log(`${this.TAG} data = ${JSON.stringify(result)}`);
      this.listTracks = result.data;
    }).catch( err => {
        console.log(` ${this.TAG} err : ${err} `);
    });
  }
}
