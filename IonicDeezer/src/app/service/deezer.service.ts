import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Artist {
  id: number;
  name: string;
  link: string;
  picture: string;
  picture_small: string;
  picture_medium: string;
  picture_big: string;
  picture_xl: string;
  nb_album: number;
  nb_fan: number;
  radio: boolean;
  tracklist: string;
  type: string;
}

export class DataSearchArtist {
  data: Artist[];
  total: number;
  next: string;
}

export class Album {
  id: number;
  title: string;
  link: string;
  cover: string;
  cover_small: string;
  cover_medium: string;
  cover_big: string;
  cover_xl: string;
  genre_id: number;
  nb_tracks: number;
  record_type: string;
  tracklist: string;
  explicit_lyrics: boolean;
  artist: Artist;
  type: string;
}

export class DataSearchAlbum {
  data: Album[];
  total: number;
  next: string;
}

export class Track {
  id: number;
  readable: boolean;
  title: string;
  title_short: string;
  title_version: string;
  link: string;
  duration: number;
  rank: number;
  explicit_lyrics: boolean;
  explicit_content_lyrics: number;
  explicit_content_cover: number;
  preview: string;
  artist: Artist;
  type: string;
}

export class DataSearchTrack {
  data: Track[];
}

@Injectable({
  providedIn: 'root'
})
export class DeezerService {
  TAG = "DeezerService";

  constructor(private http: HttpClient) {}

  getAuthors(artist: string):Promise<DataSearchArtist> {
    console.log(`${this.TAG} getAuthors ${artist}`);
    
    const url: string = "https://api.deezer.com/search/artist?q=" + encodeURI(artist);
    
    console.log(`${this.TAG} url ${url}`);
    
    return new Promise(resolve => {
      this.http.get(url).subscribe(data => {
        let json: DataSearchArtist = data as DataSearchArtist;
        resolve(json);
      }, err => {
        console.log(err);
      });
    });
  }

  getAlbums(artist: string):Promise<DataSearchAlbum> {
    console.log(`${this.TAG} getAlbums ${artist}`);
    
    const url: string = "https://api.deezer.com/search/album?q=" + encodeURI(artist);
    
    console.log(`${this.TAG} url ${url}`);
    
    return new Promise(resolve => {
      this.http.get(url).subscribe(data => {
        let json: DataSearchAlbum = data as DataSearchAlbum;
        resolve(json);
      }, err => {
        console.log(err);
      });
    });
  }

  getTracks(album: number):Promise<DataSearchTrack> {
    console.log(`${this.TAG} getTracks ${album}`);
    
    const url: string = "https://api.deezer.com/album/" + album + "/tracks";
    
    console.log(`${this.TAG} url ${url}`);
    
    return new Promise(resolve => {
      this.http.get(url).subscribe(data => {
        let json: DataSearchTrack = data as DataSearchTrack;
        resolve(json);
      }, err => {
        console.log(err);
      });
    });
  }
}
