import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee.model';

@Injectable({
  providedIn: 'root'
})
export class ImportService {
  private baseUrl = 'http://localhost:8080/api/import';

  constructor(private http: HttpClient) { }

  importXml(xmlData: string): Observable<Employee[]> {
    return this.http.post<Employee[]>(`${this.baseUrl}/xml`, xmlData);
  }
}
