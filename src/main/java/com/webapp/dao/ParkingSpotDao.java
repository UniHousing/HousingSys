package com.webapp.dao;

import com.webapp.model.ParkingSpot;


public interface ParkingSpotDao extends BaseDao<ParkingSpot> {
	public void updateAvailablity(ParkingSpot parkingSpot,boolean flag);
}
