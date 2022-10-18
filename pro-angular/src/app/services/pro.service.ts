import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const baseUrl = 'http://localhost:8080';
@Injectable({
  providedIn: 'root'
})
export class ProService {

  constructor(private http : HttpClient) { }

  getWorks(){
    return this.http.get(baseUrl+'/works');
  }
  getWorkEnvs(){
    return this.http.get(baseUrl+'/workenvs');
  }
  getWorkWeeks(){
    return this.http.get(baseUrl+'/workweeks');
  }
  getWorkById(id: any){}

  
}
