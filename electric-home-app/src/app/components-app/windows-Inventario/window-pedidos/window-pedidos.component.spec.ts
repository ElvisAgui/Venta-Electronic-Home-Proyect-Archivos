import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowPedidosComponent } from './window-pedidos.component';

describe('WindowPedidosComponent', () => {
  let component: WindowPedidosComponent;
  let fixture: ComponentFixture<WindowPedidosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowPedidosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowPedidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
