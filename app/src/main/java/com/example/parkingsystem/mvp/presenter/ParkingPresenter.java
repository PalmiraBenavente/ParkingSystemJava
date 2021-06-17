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
        model.setParkingSpace();
        view.showParkingSpacesAvailable(model.getParkingSpace());
    }
}
