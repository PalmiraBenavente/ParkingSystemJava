package com.example.parkingsystem.entity;

import com.example.parkingsystem.utils.Constants;
import java.util.Calendar;

public class Reservation {
    private Calendar startDate;
    private Calendar endDate;
    private int parkingLot;
    private int userCode;

    public Reservation() {
        this.parkingLot = Constants.INT_CERO;
        this.userCode = Constants.INT_CERO;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public int getParkingLot() {
        return parkingLot;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void setParkingLot(int parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }
}
