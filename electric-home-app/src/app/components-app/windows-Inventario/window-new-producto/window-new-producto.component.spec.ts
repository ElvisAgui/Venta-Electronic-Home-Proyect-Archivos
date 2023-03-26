import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowNewProductoComponent } from './window-new-producto.component';

describe('WindowNewProductoComponent', () => {
  let component: WindowNewProductoComponent;
  let fixture: ComponentFixture<WindowNewProductoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowNewProductoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowNewProductoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
