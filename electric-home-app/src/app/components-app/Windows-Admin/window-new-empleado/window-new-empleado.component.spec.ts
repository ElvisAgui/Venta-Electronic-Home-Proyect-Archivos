import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowNewEmpleadoComponent } from './window-new-empleado.component';

describe('WindowNewEmpleadoComponent', () => {
  let component: WindowNewEmpleadoComponent;
  let fixture: ComponentFixture<WindowNewEmpleadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowNewEmpleadoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowNewEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
