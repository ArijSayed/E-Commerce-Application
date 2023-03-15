import { TestBed } from '@angular/core/testing';

import { ShareProductDataService } from './share-product-data.service';

describe('ShareProductDataService', () => {
  let service: ShareProductDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShareProductDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
