import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControlproductComponent } from './controlproduct.component';

describe('ControlproductComponent', () => {
  let component: ControlproductComponent;
  let fixture: ComponentFixture<ControlproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ControlproductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ControlproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
