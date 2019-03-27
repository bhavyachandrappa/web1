package com.example.SayNoToHunger.DataLayer.InterfacesDL;

import java.util.List;

import com.example.SayNoToHunger.Model.RDashboard;

public interface IRDashboardDL{
	List<RDashboard> GetRDashboardStatus(int receiverId, int fooddonationId);
}
