import { Component, Input } from '@angular/core';
import { Inventory } from '../inventory';
import { CommonModule } from '@angular/common';
import { InventoryCardComponent } from '../inventory-card/inventory-card.component';

@Component({
  selector: 'app-inventory-grid',
  standalone: true,
  imports: [CommonModule, InventoryCardComponent],
  templateUrl: './inventory-grid.component.html',
  styleUrl: './inventory-grid.component.css'
})
export class InventoryGridComponent {
  @Input() inventory!: Inventory[];
}
