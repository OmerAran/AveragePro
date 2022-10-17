import { Component, OnInit } from '@angular/core';
import { ProService } from 'src/app/services/pro.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
jobs : any ;
selectedId :number = 1;
selectedHandler(event: any){
  this.selectedId = event.target.value;

}



constructor(private proService : ProService) { }

  ngOnInit(): void {
    this.getWorks();
    }

  getWorks(){
    this.proService.getWorks().subscribe(res =>{
      this.jobs = res;
    })
  }


}
