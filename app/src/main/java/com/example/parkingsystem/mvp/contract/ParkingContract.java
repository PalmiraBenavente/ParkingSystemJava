package com.example.parkingsystem.mvp.contract;

public interface ParkingContract {

    interface MainActivityModel {
        void setParkingSpace(int parkingSpace);
        int getParkingSpace();
    }

    interface MainActivityView {
        void showSelectionParkingSpaces(int parkingSpace);
        void toastShowSpaces(int parkingSpace);
        void showBookParkingPickers();
    }

    interface MainActivityPresenter {
        void onSelectParkingButtonPressed();
        void onSetParkingButtonPressed(int spaces);
        void onBookParkingSpaces();
    }
}
