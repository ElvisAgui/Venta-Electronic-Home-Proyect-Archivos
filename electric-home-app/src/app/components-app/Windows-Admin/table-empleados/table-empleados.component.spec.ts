import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableEmpleadosComponent } from './table-empleados.component';

describe('TableEmpleadosComponent', () => {
  let component: TableEmpleadosComponent;
  let fixture: ComponentFixture<TableEmpleadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableEmpleadosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TableEmpleadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
