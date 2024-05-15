import { Component, Input } from '@angular/core';
import { Inventory } from '../inventory';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-inventory-card',
  standalone: true,
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './inventory-card.component.html',
  styleUrl: './inventory-card.component.css'
})
export class InventoryCardComponent {
  @Input() item!: Inventory;
}
