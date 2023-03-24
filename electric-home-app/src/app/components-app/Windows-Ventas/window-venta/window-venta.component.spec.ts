import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowVentaComponent } from './window-venta.component';

describe('WindowVentaComponent', () => {
  let component: WindowVentaComponent;
  let fixture: ComponentFixture<WindowVentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowVentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowVentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
