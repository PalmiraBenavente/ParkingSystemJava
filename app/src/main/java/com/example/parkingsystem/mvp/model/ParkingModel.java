package com.example.parkingsystem.mvp.model;

import com.example.parkingsystem.database.ParkingDatabase;
import com.example.parkingsystem.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.MainActivityModel {
    private ParkingDatabase database;

    public ParkingModel(ParkingDatabase database) {
        this.database = database;
    }

    @Override
    public void setParkingSpace(int parkingSpace) {
        this.database.setParkingLots(parkingSpace);
    }

    @Override
    public int getParkingSpace() {
        return this.database.getParkingLots();
    }

    @Override
    public int removedOldReservation() {
        return this.database.revomedOldReservation();
    }
}
