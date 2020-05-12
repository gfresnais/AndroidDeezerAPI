import { TestBed } from '@angular/core/testing';

import { DeezerService } from './deezer.service';

describe('DeezerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DeezerService = TestBed.get(DeezerService);
    expect(service).toBeTruthy();
  });
});
