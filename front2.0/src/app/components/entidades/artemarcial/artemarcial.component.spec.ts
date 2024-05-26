import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtemarcialComponent } from './artemarcial.component';

describe('ArtemarcialComponent', () => {
  let component: ArtemarcialComponent;
  let fixture: ComponentFixture<ArtemarcialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArtemarcialComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ArtemarcialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
