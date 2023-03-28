import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarBodegaComponent } from './navbar-bodega.component';

describe('NavbarBodegaComponent', () => {
  let component: NavbarBodegaComponent;
  let fixture: ComponentFixture<NavbarBodegaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarBodegaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarBodegaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
