package com.example.SayNoToHunger.DataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.IRDashboardDL;
import com.example.SayNoToHunger.Model.RDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
//Author:Bhavya
@Repository
public class RDashboardDL implements IRDashboardDL {

	@Autowired
	private Environment applicationProperties;
	

	public List<RDashboard> GetRDashboardStatus(int receiverId, int fooddonationId) {
		Connection connection;
		List<RDashboard> dashboardstatus = null;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				dashboardstatus = new ArrayList<RDashboard>();
				CallableStatement statementr = connection.prepareCall("{call [dbo].[sp_GetFoodRequests](?)}");
				CallableStatement statementd = connection.prepareCall("{call [dbo].[sp_GetFoodDonationStatus](?)}");
				statementr.setInt("receiverId", receiverId);
				statementd.setInt("fooddonationId",fooddonationId);
				ResultSet resultSetr = statementr.executeQuery();
				ResultSet resultSetd = statementd.executeQuery();
				RDashboard status,status1;
				while(resultSetr.next()){
					status =  new RDashboard();
					status.foodname = resultSetr.getString("FOODNAME");
					 status.numberofservingsr = resultSetr.getString("NOOFSERVINGS");
					 status.date = resultSetr.getDate("FOODEXPIRYDATE");
					 dashboardstatus.add(status);
				}
				while(resultSetd.next()){
					status1 =  new RDashboard();
					 status1.Donorname = resultSetd.getString("DONORID");
					 status1.expirydate = resultSetd.getDate("FOODEXPIRYDATE");
					 status1.numberofservingsd = resultSetd.getString("NOOFSERVINGS");
					 status1.contact = resultSetd.getInt("PHONE");
 					 dashboardstatus.add(status1);
					}
				}
			} catch (Exception exception) {
				return null;
			}
			finally{
				connection = null;
			}
			return dashboardstatus;
		}
	}
