package com.example.SayNoToHunger.ServiceLayer.InterfacesSL;

import java.util.List;

import com.example.SayNoToHunger.Model.RDashboard;
//Author:Bhavya
public interface IRDashboardSL {
	List<RDashboard> GetRDashboardStatus(int receiverId, int fooddonationId);
}
