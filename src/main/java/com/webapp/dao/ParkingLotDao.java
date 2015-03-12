package com.webapp.dao;

import com.webapp.model.ParkingLot;

public interface ParkingLotDao extends BaseDao<ParkingLot>{
	public void updateSpotsNumber(ParkingLot parkingLot,int number);
}
