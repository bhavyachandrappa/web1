package com.example.SayNoToHunger.Controller;

import java.util.List;

import com.example.SayNoToHunger.Model.RDashboard;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IRDashboardSL;
//Author:Bhavya

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RDashboardController {

    @Autowired
    IRDashboardSL trackFoodDonationsService;

    @RequestMapping("/receiver")
    List<RDashboard> GetRDashboardStatus(int receiverId, int fooddonationId) {
		
        return trackFoodDonationsService.GetRDashboardStatus(receiverId,  fooddonationId);
    }
}