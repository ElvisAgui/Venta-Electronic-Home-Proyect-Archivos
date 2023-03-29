import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaReportesComponent } from './area-reportes.component';

describe('AreaReportesComponent', () => {
  let component: AreaReportesComponent;
  let fixture: ComponentFixture<AreaReportesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaReportesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AreaReportesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
