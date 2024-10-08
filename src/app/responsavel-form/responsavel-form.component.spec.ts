import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsavelFormComponent } from './responsavel-form.component';

describe('ResponsavelFormComponent', () => {
  let component: ResponsavelFormComponent;
  let fixture: ComponentFixture<ResponsavelFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResponsavelFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResponsavelFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
