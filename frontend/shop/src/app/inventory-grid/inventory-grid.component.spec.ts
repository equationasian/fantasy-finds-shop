import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InventoryGridComponent } from './inventory-grid.component';

describe('InventoryGridComponent', () => {
  let component: InventoryGridComponent;
  let fixture: ComponentFixture<InventoryGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InventoryGridComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InventoryGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
