import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeServiceService {
  user =[];
  constructor() { }
  getdetails()
  {
    console.log(this.user);
    return this.user;

  }
  adduser(data:any)
  {
    console.log(this.user);
     this.user.push(data);

  }

}
