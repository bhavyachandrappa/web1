package com.example.SayNoToHunger.ServiceLayer;

import java.util.List;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IRDashboardDL;
import com.example.SayNoToHunger.Model.RDashboard;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IRDashboardSL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Author:Bhavya
@Service
public class RDashboardService implements IRDashboardSL {

	@Autowired
	IRDashboardDL testTrackFoodDonationDL;
	public List<RDashboard> GetRDashboardStatus(int receiverId, int fooddonationId) {
		//Business logic & calls to DL
		return testTrackFoodDonationDL.GetRDashboardStatus( receiverId, fooddonationId);
	}
}