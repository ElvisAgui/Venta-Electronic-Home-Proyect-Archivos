import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowHomeVentaComponent } from './window-home-venta.component';

describe('WindowHomeVentaComponent', () => {
  let component: WindowHomeVentaComponent;
  let fixture: ComponentFixture<WindowHomeVentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowHomeVentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowHomeVentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
