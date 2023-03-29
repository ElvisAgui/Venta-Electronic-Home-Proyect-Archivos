import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowPerfilAdminComponent } from './window-perfil-admin.component';

describe('WindowPerfilAdminComponent', () => {
  let component: WindowPerfilAdminComponent;
  let fixture: ComponentFixture<WindowPerfilAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowPerfilAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowPerfilAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
