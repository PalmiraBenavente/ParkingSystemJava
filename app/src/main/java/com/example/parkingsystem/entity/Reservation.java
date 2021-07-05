package com.example.parkingsystem.entity;

import com.example.parkingsystem.utils.Constants;

public class Reservation {
    private String startDate;
    private String endDate;
    private int parkingLot;
    private int userCode;

    public Reservation() {
        this.parkingLot = Constants.INT_CERO;
        this.userCode = Constants.INT_CERO;
        this.startDate = Constants.EMPTY_STRING;
        this.endDate = Constants.EMPTY_STRING;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getParkingLot() {
        return parkingLot;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setParkingLot(int parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }
}
