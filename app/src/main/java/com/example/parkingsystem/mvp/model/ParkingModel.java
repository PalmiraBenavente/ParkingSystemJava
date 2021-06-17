package com.example.parkingsystem.mvp.model;

import com.example.parkingsystem.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.MainActivityModel {
    private int parkingSpace;

    @Override
    public void setParkingSpace() {
        this.parkingSpace = 6;
    }

    @Override
    public int getParkingSpace() {
        return this.parkingSpace;
    }
}
