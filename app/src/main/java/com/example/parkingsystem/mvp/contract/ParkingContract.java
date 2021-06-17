package com.example.parkingsystem.mvp.contract;

public interface ParkingContract {

    interface MainActivityModel {
        void setParkingSpace();
        int getParkingSpace();
    }

    interface MainActivityView {
        void showParkingSpacesAvailable(int parkingSpace);
    }

    interface MainActivityPresenter {
        void onSelectParkingButtonPressed();
    }
}
