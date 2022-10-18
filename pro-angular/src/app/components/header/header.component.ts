import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  items: MenuItem[] = [];

  constructor() { }
  
  ngOnInit(): void {
    this.items = [
      {
          label:'Home',
          icon:'pi pi-fw pi-home',
          routerLink: ['/home']
      },
     
      {
          label:'Form',
          icon:'pi pi-fw pi-user',
          items:[
              {
                  label:'New',
                  icon:'pi pi-fw pi-user',
                  routerLink: ['/form']

              }
          ]
      },
      {
          label:'Contacts',
          icon:'pi pi-fw pi-phone',
          items : [
            {
                label :'contact',
                icon:'pi pi-fw pi-desktop',
                routerLink : ['/contact']
               
          },
            {
                label :'linkedin',
                icon:'pi pi-fw pi-linkedin',
                url : 'http://linkedin.com/in/omeraran'
               
          },
          {
            label :'github',
            icon:'pi pi-fw pi-github',
            url :'http://github.com/omeraran'
           
      }
          ]
          
      },
      {
        label:'About',
        icon:'pi pi-fw pi-id-card',
        routerLink : ['/form']
    }
  ];

  }

}
