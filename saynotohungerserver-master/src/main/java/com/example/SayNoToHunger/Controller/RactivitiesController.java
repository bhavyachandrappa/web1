package com.example.SayNoToHunger.Controller;

import java.util.List;

import com.example.SayNoToHunger.Model.Ractivities;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.ITrackRactivitiesSL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Author:Bhavya
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RactivitiesController{

    @Autowired
	ITrackRactivitiesSL trackFoodDonationsService;

    @RequestMapping("/getReceiverActivities")
    List<Ractivities> GetRactivitiesstatus() {
		
        return trackFoodDonationsService.GetRactivitiesstatus();
    }
}