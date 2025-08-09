import { Component, Input, OnInit } from '@angular/core';
import { Employee } from '../../models/employee.model';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {
  @Input() employee: Employee | null = null;

  constructor() { }

  ngOnInit(): void {
  }
}
