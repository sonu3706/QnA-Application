import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopiccardComponent } from './topiccard.component';

describe('TopiccardComponent', () => {
  let component: TopiccardComponent;
  let fixture: ComponentFixture<TopiccardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopiccardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopiccardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
