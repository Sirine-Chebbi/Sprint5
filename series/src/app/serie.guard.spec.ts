import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { SerieGuard } from './serie.guard';

describe('SerieGuard', () => {
  let guard: SerieGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(SerieGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
