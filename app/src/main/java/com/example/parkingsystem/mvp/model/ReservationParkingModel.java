package com.example.parkingsystem.mvp.model;

import com.example.parkingsystem.database.ParkingDatabase;
import com.example.parkingsystem.entity.Reservation;
import com.example.parkingsystem.mvp.contract.ReservationParkingContract;

public class ReservationParkingModel implements ReservationParkingContract.ReservationActivityModel {
    private final ParkingDatabase database;
    private final Reservation reservation;

    public ReservationParkingModel(ParkingDatabase database) {
        this.database = database;
        this.reservation = new Reservation();
    }

    @Override
    public void setReservationLotCode(int parkingLot, int parkingCode) {
        this.reservation.setParkingLot(parkingLot);
        this.reservation.setUserCode(parkingCode);
    }

    @Override
    public void setStartDate(String calendarDateTime) {
        this.reservation.setStartDate(calendarDateTime);
    }

    @Override
    public void setEndDate(String calendarDateTime) {
        this.reservation.setEndDate(calendarDateTime);
    }

    @Override
    public void addReservation(Reservation reservation) {
        this.database.addReservation(reservation);
    }

    @Override
    public Reservation getReservation() {
        return this.reservation;
    }
}
