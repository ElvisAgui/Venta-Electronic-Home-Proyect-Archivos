import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarInventarioComponent } from './navbar-inventario.component';

describe('NavbarInventarioComponent', () => {
  let component: NavbarInventarioComponent;
  let fixture: ComponentFixture<NavbarInventarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarInventarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarInventarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
