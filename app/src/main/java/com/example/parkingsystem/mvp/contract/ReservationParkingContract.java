package com.example.parkingsystem.mvp.contract;

public interface ReservationParkingContract {

    interface ReservationActivityPresenter {
        void onButtonPressedSelectReserver();
    }

    interface ReservationActivityModel {
    }

    interface ReservationActivityView {
        void showDialogDataPiker();
    }
}
