import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const baseUrl  = 'http://localhost:8080';
@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(private http : HttpClient) { }

  getAvgSalaryById(id : any){
   return  this.http.get(`${baseUrl}/pro/avgsalary/${id}`);
  }
  getAvgWorkEnvById(id : any){
    return  this.http.get(`${baseUrl}/pro/avgenv/${id}`);
   }
   getAvgWorkWeekById(id : any){
    return  this.http.get(`${baseUrl}/pro/avgweek/${id}`);
   }
}
