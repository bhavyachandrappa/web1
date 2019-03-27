package com.example.SayNoToHunger.ServiceLayer;

import java.util.List;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.ITrackRactivitiesDL;
import com.example.SayNoToHunger.Model.Ractivities;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.ITrackRactivitiesSL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackRactivitiesService implements ITrackRactivitiesSL {

	@Autowired
	ITrackRactivitiesDL testTrackFoodDonationDL;
	public List<Ractivities> GetRactivitiesstatus() {
		//Business logic & calls to DL
		return testTrackFoodDonationDL.GetRactivitiesstatus();
	}
}