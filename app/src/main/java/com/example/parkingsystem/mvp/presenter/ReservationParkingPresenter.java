package com.example.parkingsystem.mvp.presenter;

import com.example.parkingsystem.entity.Reservation;
import com.example.parkingsystem.mvp.contract.ReservationParkingContract;
import com.example.parkingsystem.utils.Constants;
import com.example.parkingsystem.utils.EnumReservationVerify;
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
        model.setReservationLotCode(getIntegerUserData(view.getParkingLot()), getIntegerUserData(view.getParkingCode()));
        Reservation reservation = model.getReservation();
        EnumReservationVerify check = model.reservationVerify(reservation);
        switch (check) {
            case MISSING_DATESTART:
            case MISSING_DATEEND:
                view.toastShowMissingDate();
                break;
            case MISSING_LOT:
                view.toastShowMissingLot();
                break;
            case MISSING_CODE:
                view.toastShowMissingCode();
                break;
            case COMPROBATION_OK:
                view.toastShowReserveOK();
                break;
            case RESERVATION_OVERLAP:
                view.toastShowOverlap();
        }
        if (check == EnumReservationVerify.COMPROBATION_OK) {
            model.addReservation(reservation);
            view.toastShowTextData(reservation.getParkingLot(), reservation.getUserCode(), this.getStringDate(reservation.getStartDate()), this.getStringDate(reservation.getEndDate()));
        }
    }

    public void setReservation(Calendar calendarDateTime, boolean startDate) {
        if (startDate) {
            model.setStartDate(calendarDateTime);
        } else {
            model.setEndDate(calendarDateTime);
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
