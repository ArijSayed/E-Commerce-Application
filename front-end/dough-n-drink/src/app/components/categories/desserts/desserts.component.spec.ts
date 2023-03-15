import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DssertsComponent } from './desserts.component';

describe('DssertsComponent', () => {
  let component: DssertsComponent;
  let fixture: ComponentFixture<DssertsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DssertsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DssertsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
