package com.example.parkingsystem.mvp.presenter;

import com.example.parkingsystem.mvp.contract.ReservationParkingContract;

public class ReservationParkingPresenter implements ReservationParkingContract.ReservationActivityPresenter {
    private ReservationParkingContract.ReservationActivityView view;

    public ReservationParkingPresenter(ReservationParkingContract.ReservationActivityView view) {
        this.view = view;
    }

    public void onButtonPressedSelectReserver() {
        view.showDialogDataPiker();
    }
}
