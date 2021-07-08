package com.example.parkingsystem.mvp.contract;

import com.example.parkingsystem.entity.Reservation;
import com.example.parkingsystem.utils.EnumReservationVerify;
import java.util.Calendar;

public interface ReservationParkingContract {

    interface ReservationActivityPresenter {
        void onButtonStartPressedSelectReserver();
        void onButtonEndPressedSelectReserver();
        void onButtonPressedSaveReserver();
        void setReservation(Calendar calendarDateTime, boolean startDate);
    }

    interface ReservationActivityModel {
        void setReservationLotCode(int parkingLot, int parkingCode);
        void setStartDate(Calendar calendarDateTime);
        void setEndDate(Calendar calendarDateTime);
        void addReservation(Reservation reservation);
        Reservation getReservation();
        EnumReservationVerify reservationVerify(Reservation reservation);
    }

    interface ReservationActivityView {
        void showDialogDataPiker(boolean startDatePiker);
        String getParkingLot();
        String getParkingCode();
        void toastShowTextData(int lot, int code, String date1, String date2);
        void toastShowOverlap();
        void toastShowReserveOK();
        void toastShowMissingCode();
        void toastShowMissingLot();
        void toastShowMissingDate();
    }
}
