import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ListTrackPage } from './list-track.page';

describe('ListTrackPage', () => {
  let component: ListTrackPage;
  let fixture: ComponentFixture<ListTrackPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListTrackPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ListTrackPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
