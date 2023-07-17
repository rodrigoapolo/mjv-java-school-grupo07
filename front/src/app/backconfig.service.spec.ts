import { TestBed } from '@angular/core/testing';

import { BackconfigService } from './backconfig.service';

describe('BackconfigService', () => {
  let service: BackconfigService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BackconfigService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
