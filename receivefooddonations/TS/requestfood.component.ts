import { Component, OnInit } from '@angular/core';
import { ReceiveFoodService } from '../../shared/services/receiveFood.service';
import { foodrequeststatus } from '../../shared/model/foodrequest.model';
import {  FormBuilder, Validators } from '@angular/forms';

//Author:Bhavya


@Component({
  selector: 'app-request-food',
  templateUrl: '../HTML/requestfood.component.html',
  styleUrls: ['../CSS/requestfood.component.css']
})




  export class RequestFoodComponent{
   
    constructor(private fb: FormBuilder, private receiveFoodService: ReceiveFoodService) { }
    
    requestfood = this.fb.group({     
      foodName: [null, Validators.required],
      NoofServings: [null, Validators.required],
      Requiredon: [null, Validators.required],
      Comment: ['']
    });
  

  insertrequestFood() {      
    console.log('Service event handler called');
    const foodrequeststatus: foodrequeststatus = {
     receiverid: 111,
     foodname: 'Burgers',
     numberofservings: 15,
     requestdate: new Date('02-08-2019'),
     comments: 'Thank you'
    };
    this.receiveFoodService.insertfoodrequeststatusIntoTracker(foodrequeststatus).subscribe(x => console.log(x));
  }

  onSubmit() {
    if (this.requestfood.valid) {
      console.log('form submitted');
    } else {
      console.log('form incorrect');
    }
  }

  callService() {
    this.receiveFoodService. getRequestfoodByreceiverId(1).subscribe(x => console.log(x));
  }
}
