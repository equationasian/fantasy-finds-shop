import { Component, OnInit } from '@angular/core';
import { MatSidenavModule } from "@angular/material/sidenav";
import { MatCheckbox, MatCheckboxModule } from "@angular/material/checkbox";
import { MatRadioButton, MatRadioModule } from "@angular/material/radio";
import { InventoryService } from '../inventory.service';
import { Inventory } from '../inventory';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { InventoryCardComponent } from '../inventory-card/inventory-card.component';
import { InventoryGridComponent } from '../inventory-grid/inventory-grid.component';

@Component({
  selector: 'app-clothing',
  standalone: true,
  imports: [CommonModule, FormsModule, InventoryCardComponent, InventoryGridComponent, MatSidenavModule, MatCheckboxModule, MatRadioModule],
  templateUrl: './clothing.component.html',
  styleUrl: './clothing.component.css'
})
export class ClothingComponent implements OnInit {
  tags: string[] = ["clothing"];
  inventory: Inventory[] = [];
  seriesOrigin: string = "";

  constructor(private inventoryService: InventoryService) {}

  ngOnInit(): void {
    this.inventoryService.filterClothing(this.tags).subscribe(list => this.inventory = list);
  }

  onTagsChange(tag: MatCheckbox): void {
    let tagValue: string = tag.value;
    if (this.tags.includes(tagValue)) {
      this.tags.splice(this.tags.indexOf(tagValue), 1);
    }
    else {
      this.tags.push(tagValue);
    }

    this.inventoryService.filterClothing(this.tags).subscribe(list => this.inventory = list);
  }

  onSeriesClick(series: MatRadioButton): void {
    if (series.checked) {
      this.seriesOrigin = series.value;
    }
    else {
      this.seriesOrigin = "";
    }
  }
}