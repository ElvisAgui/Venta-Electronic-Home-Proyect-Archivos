import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowClientesComponent } from './window-clientes.component';

describe('WindowClientesComponent', () => {
  let component: WindowClientesComponent;
  let fixture: ComponentFixture<WindowClientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowClientesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
