import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowProductosBodegaComponent } from './window-productos-bodega.component';

describe('WindowProductosBodegaComponent', () => {
  let component: WindowProductosBodegaComponent;
  let fixture: ComponentFixture<WindowProductosBodegaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowProductosBodegaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowProductosBodegaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
