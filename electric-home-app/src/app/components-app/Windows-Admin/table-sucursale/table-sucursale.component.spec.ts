import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableSucursaleComponent } from './table-sucursale.component';

describe('TableSucursaleComponent', () => {
  let component: TableSucursaleComponent;
  let fixture: ComponentFixture<TableSucursaleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableSucursaleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TableSucursaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
