package com.example.parkingsystem.mvp.presenter;

import com.example.parkingsystem.mvp.contract.ParkingContract;

public class ParkingPresenter implements ParkingContract.MainActivityPresenter {
    private ParkingContract.MainActivityModel model;
    private ParkingContract.MainActivityView view;

    public ParkingPresenter(ParkingContract.MainActivityModel model, ParkingContract.MainActivityView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onSelectParkingButtonPressed() {
        view.showSelectionParkingSpaces();
    }

    @Override
    public void onSetParkingButtonPressed(int spaces) {
        model.setParkingSpace(spaces);
        view.toastShowSpaces(model.getParkingSpace());
    }

    @Override
    public void onBookParkingSpaces() {
        onRemovedOldReservation();
        view.showBookParkingPickers();
    }

    @Override
    public void onRemovedOldReservation() {
        view.showToasRemovedReservation(model.removedOldReservation());
    }
}
