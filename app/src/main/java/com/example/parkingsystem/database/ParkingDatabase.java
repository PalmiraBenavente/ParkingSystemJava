package com.example.parkingsystem.database;

import com.example.parkingsystem.entity.Reservation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingDatabase {
    private static ParkingDatabase databaseSingleInstance = null;
    HashMap<Integer, List<Reservation>> hashMapReservation = new HashMap<>();

    public ParkingDatabase() {
    }

    public static ParkingDatabase getInstance() {
        if (databaseSingleInstance == null) {
            databaseSingleInstance = new ParkingDatabase();
        }
        return databaseSingleInstance;
    }

    public void addReservation(Reservation reservation) {
        List<Reservation> reserve = new ArrayList<>();
        int parkingLot = reservation.getParkingLot();
        if (hashMapReservation.containsKey(parkingLot)) {
            reserve = hashMapReservation.get(parkingLot);
        }
        reserve.add(reservation);
        hashMapReservation.put(parkingLot, reserve);
    }
}
