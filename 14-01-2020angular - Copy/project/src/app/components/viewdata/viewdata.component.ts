import { Component, OnInit, Input } from '@angular/core';
import { HomeServiceService } from 'src/app/providers/home-service.service';

@Component({
  selector: 'app-viewdata',
  templateUrl: './viewdata.component.html',
  styleUrls: ['./viewdata.component.css']
})
export class ViewdataComponent implements OnInit {
  
   user:any;
  constructor(public d:HomeServiceService) { }

  ngOnInit() {
    console.log("view init");
  this.user=this.d.getdetails();
  console.log(this.user);
  }

}
