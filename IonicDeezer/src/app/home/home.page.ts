import { Component } from '@angular/core';
import { DeezerService, DataSearchArtist, Artist } from '../service/deezer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  TAG = "HomePage";

  listArtists: Artist[];

  constructor(public deezerService: DeezerService, public router: Router) {}

  onSearchArtist(event: any) {
    let text: string = event.target.value;
    
    this.deezerService.getAuthors(text).then( result => {
      console.log(`${this.TAG} data = ${JSON.stringify(result)}`);
      this.listArtists = result.data;
    }).catch( err => {
        console.log(` ${this.TAG} err : ${err} `);
    });
  }

  onClickArtist(artist: Artist) {
    console.log(`${this.TAG} onClickArtist = ${JSON.stringify(artist)}`);
    this.router.navigate(['list-album/' + artist.name]);
  }

}
