import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowProductosComponent } from './window-productos.component';

describe('WindowProductosComponent', () => {
  let component: WindowProductosComponent;
  let fixture: ComponentFixture<WindowProductosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowProductosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowProductosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
