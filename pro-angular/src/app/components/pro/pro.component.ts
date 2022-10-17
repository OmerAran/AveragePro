import { Component, OnInit } from '@angular/core';
import { FormService } from 'src/app/services/form.service';

@Component({
  selector: 'app-pro',
  templateUrl: './pro.component.html',
  styleUrls: ['./pro.component.css']
})
export class ProComponent implements OnInit {
  result : any ;
  constructor(private service : FormService) { }

  ngOnInit(): void {
    this.getAvgSalaryById(3);
  }

  getAvgSalaryById(id:any){
    this.service.getAvgSalaryById(id).subscribe(res =>{
      this.result = res;
    })
  }
  getAvgWorkEnvById(id:any){
    this.service.getAvgWorkEnvById(id).subscribe(res =>{
      this.result = res;
    })
  }
  getAvgWorkWeekById(id:any){
    this.service.getAvgWorkWeekById(id).subscribe(res =>{
      this.result = res;
    })
  }

}
