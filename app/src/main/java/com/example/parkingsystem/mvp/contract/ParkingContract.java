package com.example.parkingsystem.mvp.contract;

public interface ParkingContract {

    interface MainActivityModel {
        void setParkingSpace(int parkingSpace);
        int getParkingSpace();
        int removedOldReservation();
    }

    interface MainActivityView {
        void showSelectionParkingSpaces();
        void toastShowSpaces(int parkingSpace);
        void showBookParkingPickers();
        void showToasRemovedReservation(int cantOldResevations);
    }

    interface MainActivityPresenter {
        void onSelectParkingButtonPressed();
        void onSetParkingButtonPressed(int spaces);
        void onBookParkingSpaces();
        void onRemovedOldReservation();
    }
}
