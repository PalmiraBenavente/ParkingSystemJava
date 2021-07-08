package com.example.parkingsystem.mvp.presenter;

import android.content.Context;
import com.example.parkingsystem.utils.Constants;
import com.example.parkingsystem.entity.Reservation;
import com.example.parkingsystem.mvp.contract.ReservationParkingContract;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReservationParkingPresenter implements ReservationParkingContract.ReservationActivityPresenter {
    private ReservationParkingContract.ReservationActivityView view;
    private ReservationParkingContract.ReservationActivityModel model;

    public ReservationParkingPresenter(ReservationParkingContract.ReservationActivityView view, ReservationParkingContract.ReservationActivityModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onButtonStartPressedSelectReserver() {
        view.showDialogDataPiker(true);
    }

    @Override
    public void onButtonEndPressedSelectReserver() {
        view.showDialogDataPiker(false);
    }

    public void onButtonPressedSaveReserver() {
        model.setReservationLotCode(this.getIntegerUserData(view.getParkingLot()), this.getIntegerUserData(view.getParkingCode()));
        Reservation reservation = model.getReservation();
        model.addReservation(reservation);
        view.toastShowTextData(reservation.getParkingLot(), reservation.getUserCode(), reservation.getStartDate(), reservation.getEndDate());
    }

    public void setReservation(Calendar calendarDateTime, boolean startDate) {
        if (startDate) {
            model.setStartDate(this.getStringDate(calendarDateTime));
        } else {
            model.setEndDate(this.getStringDate(calendarDateTime));
        }
    }

    private String getStringDate(Calendar calendar) {
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.FORMAT_DATE);
        String dateToString = Constants.EMPTY_STRING;
        try {
            dateToString = simpleDateFormat.format(date);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return dateToString;
    }

    private int getIntegerUserData(String userData) {
        if (userData.isEmpty()) {
            return Constants.INT_MINUS_ONE;
        } else
            return Integer.parseInt(userData);
    }
}
