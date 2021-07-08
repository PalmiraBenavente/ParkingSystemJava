package com.example.parkingsystem.database;

import com.example.parkingsystem.entity.Reservation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingDatabase {
    private static ParkingDatabase databaseSingleInstance = null;
    private final HashMap<Integer, List<Reservation>> hashMapReservation = new HashMap<>();

    public ParkingDatabase() {
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
}
