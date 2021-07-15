package com.example.parkingsystem.utils;

import com.example.parkingsystem.database.ParkingDatabase;
import com.example.parkingsystem.entity.Reservation;
import java.util.Calendar;
import java.util.List;

public class ReservationChecker {

    private final ParkingDatabase database;

    public ReservationChecker(ParkingDatabase database) {
        this.database = database;
    }

    public EnumReservationVerify checkReservation(Reservation reservation) {
        if (reservation.getStartDate() == null) {
            return EnumReservationVerify.MISSING_DATESTART;
        }
        if (reservation.getEndDate() == null) {
            return EnumReservationVerify.MISSING_DATEEND;
        }
        if (reservation.getParkingLot() == Constants.NOT_VALID) {
            return EnumReservationVerify.MISSING_LOT;
        }
        if (reservation.getUserCode() == Constants.NOT_VALID) {
            return EnumReservationVerify.MISSING_CODE;
        }
        if (!reservationOK(reservation)) {
            return EnumReservationVerify.RESERVATION_OVERLAP;
        } else {
            return EnumReservationVerify.COMPROBATION_OK;
        }
    }

    private boolean reservationOK(Reservation reservation) {
        int lot = reservation.getParkingLot();
        if (database.getHashMapReservation().containsKey(lot)) {
            List<Reservation> reservationsOnLot = database.getHashMapReservation().get(lot);
            for (Reservation i : reservationsOnLot) {
                if (isOverlap(i, reservation)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isOverlap(Reservation reservation, Reservation reservationAux) {
        Calendar reservationStartDate = reservation.getStartDate();
        Calendar reservationEndDate = reservation.getEndDate();
        Calendar reservationStartDateAux = reservationAux.getStartDate();
        Calendar reservationEndDateAux = reservationAux.getEndDate();
        if (reservationStartDate.before(reservationStartDateAux) && reservationEndDate.after(reservationStartDateAux)) {
            return true;
        }
        if (reservationStartDate.before(reservationEndDateAux) && reservationEndDate.after(reservationEndDateAux)) {
            return true;
        } else {
            return reservationStartDate.after(reservationStartDateAux) && reservationEndDate.before(reservationEndDateAux);
        }
    }
}
