import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WindowRootComponent } from './window-root.component';

describe('WindowRootComponent', () => {
  let component: WindowRootComponent;
  let fixture: ComponentFixture<WindowRootComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WindowRootComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WindowRootComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
