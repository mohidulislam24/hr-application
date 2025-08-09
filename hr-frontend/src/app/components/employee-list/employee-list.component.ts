import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee.model';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];
  selectedEmployee: Employee | null = null;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.loadEmployees();
  }

  loadEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      data => {
        this.employees = data;
      },
      error => {
        console.error('Error fetching employees', error);
      }
    );
  }

  selectEmployee(employee: Employee): void {
    this.selectedEmployee = employee;
  }

  deleteEmployee(id: number): void {
    if (confirm('Are you sure you want to delete this employee?')) {
      this.employeeService.deleteEmployee(id).subscribe(
        () => {
          this.loadEmployees();
          if (this.selectedEmployee && this.selectedEmployee.id === id) {
            this.selectedEmployee = null;
          }
        },
        error => {
          console.error('Error deleting employee', error);
        }
      );
    }
  }
}
