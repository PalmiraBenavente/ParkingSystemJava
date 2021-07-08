package com.example.parkingsystem.mvp.model;

import com.example.parkingsystem.database.ParkingDatabase;
import com.example.parkingsystem.entity.Reservation;
import com.example.parkingsystem.mvp.contract.ReservationParkingContract;
import com.example.parkingsystem.utils.EnumReservationVerify;
import com.example.parkingsystem.utils.ReservationChecker;
import java.util.Calendar;

public class ReservationParkingModel implements ReservationParkingContract.ReservationActivityModel {
    private final ParkingDatabase database;
    private final Reservation reservation;
    private final ReservationChecker reservationChecker;

    public ReservationParkingModel(ParkingDatabase database, ReservationChecker reservationChecker) {
        this.database = database;
        this.reservation = new Reservation();
        this.reservationChecker = reservationChecker;
    }

    @Override
    public void setReservationLotCode(int parkingLot, int parkingCode) {
        this.reservation.setParkingLot(parkingLot);
        this.reservation.setUserCode(parkingCode);
    }

    @Override
    public void setStartDate(Calendar calendarDateTime) {
        this.reservation.setStartDate(calendarDateTime);
    }

    @Override
    public void setEndDate(Calendar calendarDateTime) {
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

    @Override
    public EnumReservationVerify reservationVerify(Reservation reservation) {
        return reservationChecker.checkReservation(reservation);
    }
}
