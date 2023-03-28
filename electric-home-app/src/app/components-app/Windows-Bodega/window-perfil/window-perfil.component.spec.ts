import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowPerfilComponent } from './window-perfil.component';

describe('WindowPerfilComponent', () => {
  let component: WindowPerfilComponent;
  let fixture: ComponentFixture<WindowPerfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowPerfilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
