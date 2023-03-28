import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowPedidosBodegaComponent } from './window-pedidos-bodega.component';

describe('WindowPedidosBodegaComponent', () => {
  let component: WindowPedidosBodegaComponent;
  let fixture: ComponentFixture<WindowPedidosBodegaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowPedidosBodegaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowPedidosBodegaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
