import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee.model';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent implements OnInit {
  @Input() employee: Employee | null = null;
  @Output() formSubmit = new EventEmitter<void>();

  formEmployee: Employee = {
    id: 0,
    firstName: '',
    lastName: '',
    title: '',
    division: '',
    building: '',
    room: ''
  };

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    if (this.employee) {
      this.formEmployee = { ...this.employee };
    }
  }

  onSubmit(): void {
    if (this.employee) {
      this.employeeService.updateEmployee(this.formEmployee).subscribe(
        () => {
          this.formSubmit.emit();
        },
        error => {
          console.error('Error updating employee', error);
        }
      );
    }
  }
}
