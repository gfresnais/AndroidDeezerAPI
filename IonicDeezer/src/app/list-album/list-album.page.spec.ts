import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ListAlbumPage } from './list-album.page';

describe('ListAlbumPage', () => {
  let component: ListAlbumPage;
  let fixture: ComponentFixture<ListAlbumPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListAlbumPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ListAlbumPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
