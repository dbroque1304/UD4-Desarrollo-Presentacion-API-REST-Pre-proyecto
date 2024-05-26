import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArteMarcialComponent } from './arte-marcial.component';

describe('ArteMarcialComponent', () => {
  let component: ArteMarcialComponent;
  let fixture: ComponentFixture<ArteMarcialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ArteMarcialComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ArteMarcialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
