import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Inventory } from './inventory';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
  private inventoryUrl = "http://localhost:8080/api/inventory";

  constructor(private http: HttpClient) { }

  getAllItems(): Observable<Inventory[]> {
    return this.http.get<Inventory[]>(this.inventoryUrl);
  }

  filterClothing(tags: string[]): Observable<Inventory[]> {
    let tagsParams = new HttpParams().appendAll({ "tags": tags });
    return this.http.get<Inventory[]>(this.inventoryUrl, { params: tagsParams });
  }
}