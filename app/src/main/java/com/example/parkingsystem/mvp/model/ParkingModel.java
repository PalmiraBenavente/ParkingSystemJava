package com.example.parkingsystem.mvp.model;

import com.example.parkingsystem.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.MainActivityModel {
    private int parkingSpace;

    @Override
    public void setParkingSpace(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    @Override
    public int getParkingSpace() {
        return this.parkingSpace;
    }
}
