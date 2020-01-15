import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl, Validators } from '@angular/forms'
import { HomeServiceService } from 'src/app/providers/home-service.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    
  constructor(public d:HomeServiceService) { }

  myForm=new FormGroup(
    {
      firstname : new FormControl('',Validators.required),
      lastname : new FormControl('',Validators.required),
      id :new FormControl('',Validators.required),
      contact :new FormControl('',Validators.required)
    }
  );
  submit()
  {
    this.d.adduser(this.myForm.value);
  }
  ngOnInit() {
   
  }
  formValid=true;
  errname="";
  errlast=""
  errid="";
  errcon="";
  check(){
    
    this.formValid=true;
    var reg=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
    if(!reg.test(this.myForm.value.firstname))
    {
      this.formValid=false;
      this.errname="Enter Valid firstName";
    }
    else{
      this.errname=" "
    }
    var reg3=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
    if(!reg3.test(this.myForm.value.lastname))
    {
      this.formValid=false;
      this.errlast="Enter Valid lastName";
    }
    else{
      this.errlast=" "
    }
    var x=this.myForm.value.id;
    x=x.toString();
    console.log(x.length);
    if(!(x.length==2)){
     this.formValid=false;
     this.errid="Enter 2digit Valid id";
    }
    else{
     this.errid=" "
    }
   var x=this.myForm.value.contact;
   x=x.toString();
   console.log(x.length);
   if(!(x.length==10)){
    this.formValid=false;
    this.errcon="Enter 10digit Valid contact";
   }
   else{
    this.errcon=" "
   }
}
}