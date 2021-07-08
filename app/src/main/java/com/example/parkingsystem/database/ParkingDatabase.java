package com.example.parkingsystem.database;

import com.example.parkingsystem.entity.Reservation;
import com.example.parkingsystem.utils.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class ParkingDatabase {
    private static ParkingDatabase databaseSingleInstance = null;
    private final HashMap<Integer, List<Reservation>> hashMapReservation = new HashMap<>();
    private int parkingLots;

    public ParkingDatabase() {
    }

    public void setParkingLots(int parkingLots) {
        this.parkingLots = parkingLots;
    }

    public int getParkingLots() {
        return parkingLots;
    }

    public static ParkingDatabase getInstance() {
        if (databaseSingleInstance == null) {
            databaseSingleInstance = new ParkingDatabase();
        }
        return databaseSingleInstance;
    }

    public HashMap<Integer, List<Reservation>> getHashMapReservation() {
        return hashMapReservation;
    }

    public void addReservation(Reservation reservation) {
        List<Reservation> reserve = new ArrayList<>();
        int parkingLot = reservation.getParkingLot();
        if (hashMapReservation.containsKey(parkingLot)) {
            this.hashMapReservation.get(parkingLot).add(reservation);
        } else {
            reserve.add(reservation);
            this.hashMapReservation.put(parkingLot, reserve);
        }
    }

    public int revomedOldReservation() {
        Calendar currentTime = new GregorianCalendar();
        HashMap<Integer, List<Reservation>> reservationsHash = this.getHashMapReservation();
        Integer cantRemoved = Constants.QUANTITY_ZERO;
        for (int lot = Constants.INT_CERO; lot <= this.getParkingLots(); lot++) {
            if (reservationsHash.containsKey(lot)) {
                cantRemoved += removedReservationInLot(currentTime, this.getHashMapReservation().get(lot));
            }
        }
        return cantRemoved;
    }

    private int removedReservationInLot(Calendar currentTime, List<Reservation> reservations) {
        Integer cantRemovedOnLot = Constants.QUANTITY_ZERO;
        Reservation reserve;
        for (int reservationInLot = Constants.INT_CERO; reservationInLot < reservations.size(); reservationInLot++) {
            reserve = reservations.get(reservationInLot);
            if (currentTime.after(reserve.getEndDate())) {
                reservations.remove(reservationInLot);
                cantRemovedOnLot++;
            }
        }
        return cantRemovedOnLot;
    }
}
