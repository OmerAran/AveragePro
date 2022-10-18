import { Component, OnInit } from '@angular/core';
import { Pro } from 'src/app/interfaces/pro';
import { ProService } from 'src/app/services/pro.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  works: any;
  workEnvs : any;
  workWeeks : any;
  pro : Pro;



  selectedHandler(event: any){
    this.pro.work = event.target.value;
    this.pro.workEnv = event.target.value;
    this.pro.workWeek = event.target.value;
  }

  constructor(private proService : ProService) { }

  ngOnInit(): void {
    this.getWorks();
    this.getWorkEnvs();
    this.getWorkWeeks();
  }

  getWorks(){
    this.proService.getWorks().subscribe(res=> {
      this.works=res;
    })
  }
  getWorkEnvs(){
    this.proService.getWorkEnvs().subscribe(envs =>{
      this.workEnvs =envs;
    })
    
  }
  getWorkWeeks(){
    this.proService.getWorkWeeks().subscribe(weeks =>{
      this.workWeeks =weeks;
    })
  }



}
