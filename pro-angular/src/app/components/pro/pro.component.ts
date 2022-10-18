import { Component, OnInit } from '@angular/core';
import { FormService } from 'src/app/services/form.service';
@Component({
  selector: 'app-pro',
  templateUrl: './pro.component.html',
  styleUrls: ['./pro.component.css']
})
export class ProComponent implements OnInit {
  
  salary : any;
  workEnv : any;
  workWeek : any;
  constructor(private service : FormService) { }

  ngOnInit(): void {
    this.getAvgSalaryById(3);
    this.getAvgWorkEnvById(3);
    this.getAvgWorkWeekById(3);
  }

  getAvgSalaryById(id:any){
    this.service.getAvgSalaryById(id).subscribe(res =>{
      this.salary = res;
    })
  }
  getAvgWorkEnvById(id:any){
    this.service.getAvgWorkEnvById(id).subscribe(res =>{
      this.workEnv = res;
    })
  }
  getAvgWorkWeekById(id:any){
    this.service.getAvgWorkWeekById(id).subscribe(res =>{
      this.workWeek = res;
    })
  }

}
