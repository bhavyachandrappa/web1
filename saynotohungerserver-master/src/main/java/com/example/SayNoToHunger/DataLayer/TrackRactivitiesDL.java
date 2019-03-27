package com.example.SayNoToHunger.DataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

import com.example.SayNoToHunger.DataLayer.InterfacesDL.ITrackRactivitiesDL;
import com.example.SayNoToHunger.Model.Ractivities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
//Author:Bhavya
@Repository
public class TrackRactivitiesDL implements ITrackRactivitiesDL {

	@Autowired
	private Environment applicationProperties;

	public List<Ractivities> GetRactivitiesstatus() {
		Connection connection;
		List<Ractivities> ractivitiesstatus = null;
		String connectionString = applicationProperties.getProperty("connectionString");
		try {
			connection =  DriverManager.getConnection(connectionString);
			if(connection != null){
				ractivitiesstatus = new ArrayList<Ractivities>();
				CallableStatement statement = connection.prepareCall("{call [dbo].[FOODDONATIONS]()}");
				ResultSet resultSet = statement.executeQuery();
				Ractivities status;
				while(resultSet.next()){
					status =  new Ractivities();
					 status.foodname = resultSet.getString("FOODNAME");
					 status.numberofservingsd = resultSet.getString("NOOFSERVINGS");
					 status.status= resultSet.getString("STATUS"); //inprogess or completed
					 status.donorname = resultSet.getString("DONORID");
					 status.expirydate = resultSet.getDate("FOODEXPIRYDATE");
					 
					 //String status1;
					
					ractivitiesstatus.add(status);
				}
			}
		} catch (Exception exception) {
			return null;
		}
		return ractivitiesstatus;
	}

}
