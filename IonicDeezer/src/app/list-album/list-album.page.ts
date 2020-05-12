import { Component, OnInit } from '@angular/core';
import { Album, DeezerService } from '../service/deezer.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-album',
  templateUrl: './list-album.page.html',
  styleUrls: ['./list-album.page.scss'],
})
export class ListAlbumPage implements OnInit {
  TAG = "ListAlbumPage";

  name: string;

  listAlbums: Album[];

  constructor(public deezerService: DeezerService, public router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.name = this.activatedRoute.snapshot.paramMap.get('name');
    console.log(`${this.TAG} initListAlbumPage = ${name}`);
    this.searchAlbums();
  }

  searchAlbums() {
    this.deezerService.getAlbums(this.name).then( result => {
      console.log(`${this.TAG} data = ${JSON.stringify(result)}`);
      this.listAlbums = result.data;
    }).catch( err => {
        console.log(` ${this.TAG} err : ${err} `);
    });
  }

  onClickAlbum(album: Album) {
    console.log(`${this.TAG} onClickAlbum = ${JSON.stringify(album)}`);
    this.router.navigate(['list-track/' + album.id]);
  }

}
