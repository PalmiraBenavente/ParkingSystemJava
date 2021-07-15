package com.example.parkingsystem.mvp.presenter;

import com.example.parkingsystem.database.ParkingDatabase;
import com.example.parkingsystem.entity.Reservation;
import com.example.parkingsystem.mvp.contract.ReservationParkingContract;
import com.example.parkingsystem.mvp.model.ReservationParkingModel;
import com.example.parkingsystem.utils.ReservationChecker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class ReservationParkingPresenterTest {

    private static final int YEAR = 2021;
    private static final int MONTH = 6;
    private static final int DAY_START = 9;
    private static final int DAY_END = 16;
    private static final int HOUR = 11;
    private static final int MINUTE = 11;
    private static final int ZERO = 0;
    private static final int PARKING_LOT = 5;
    private static final int USER_CODE = 123;
    public static final String EMPTY_STRING = "";
    public static final String FORMAT_DATE = "hh: mm a dd-MMM-yyyy";
    private static final int EMPTY_LOT = -1;
    private static final int END_DAY_OVERLAP = 15;
    private static final int PARKING_LOTS = 8;
    private static final int END_DAY_START_OVERLAP = 8;

    ReservationParkingContract.ReservationActivityPresenter presenter;
    ReservationParkingContract.ReservationActivityModel model;
    @Mock
    ReservationParkingContract.ReservationActivityView view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        model = new ReservationParkingModel(ParkingDatabase.getInstance(), new ReservationChecker(ParkingDatabase.getInstance()));
        presenter = new ReservationParkingPresenter(view, model);
    }

    @Test
    public void onButtonStartPressedSelectReserverTest() {
        presenter.onButtonStartPressedSelectReserver();
        verify(view).showDialogDataPiker(true);
    }

    @Test
    public void onButtonEndPressedSelectReserverTest() {
        presenter.onButtonEndPressedSelectReserver();
        verify(view).showDialogDataPiker(false);
    }

    @Test
    public void setReservationTest() {
        presenter.setReservation(getStartCalendar(), true);
        assertEquals(getStartCalendar(), model.getReservation().getStartDate());
        presenter.setReservation(getEndCalendar(), false);
        assertEquals(getEndCalendar(), model.getReservation().getEndDate());
    }

    @Test
    public void onButtonPressedSaveReserverTest() {
        Mockito.when(view.getParkingLot()).thenReturn(String.valueOf(PARKING_LOT));
        Mockito.when(view.getParkingCode()).thenReturn(String.valueOf(USER_CODE));
        presenter.setReservation(getStartCalendar(), true);
        presenter.setReservation(getEndCalendar(), false);
        presenter.onButtonPressedSaveReserver();
        Reservation testReservation = model.getReservation();
        assertEquals(getStartCalendar(), testReservation.getStartDate());
        assertEquals(getEndCalendar(), testReservation.getEndDate());
        assertEquals(PARKING_LOT, testReservation.getParkingLot());
        assertEquals(USER_CODE, testReservation.getUserCode());
        verify(view).toastShowReserveOK();
        verify(view).toastShowTextData(PARKING_LOT, USER_CODE, getStringDate(getStartCalendar()), getStringDate(getEndCalendar()));
    }

    @Test
    public void onButtonPressedSaveReserverMissingDateStartTest() {
        Mockito.when(view.getParkingLot()).thenReturn(String.valueOf(PARKING_LOT));
        Mockito.when(view.getParkingCode()).thenReturn(EMPTY_STRING);
        presenter.onButtonPressedSaveReserver();
        verify(view).toastShowMissingDate();
    }

    @Test
    public void onButtonPressedSaveReserverMissingDateEndTest() {
        Mockito.when(view.getParkingLot()).thenReturn(String.valueOf(PARKING_LOT));
        Mockito.when(view.getParkingCode()).thenReturn(EMPTY_STRING);
        presenter.setReservation(getStartCalendar(), true);
        assertEquals(getStartCalendar(), model.getReservation().getStartDate());
        presenter.onButtonPressedSaveReserver();
        verify(view).toastShowMissingDate();
    }

    @Test
    public void onButtonPressedSaveReserverMissingLotTest() {
        Mockito.when(view.getParkingLot()).thenReturn(String.valueOf(EMPTY_LOT));
        Mockito.when(view.getParkingCode()).thenReturn(EMPTY_STRING);
        presenter.setReservation(getStartCalendar(), true);
        presenter.setReservation(getEndCalendar(), false);
        assertEquals(getEndCalendar(), model.getReservation().getEndDate());
        presenter.onButtonPressedSaveReserver();
        verify(view).toastShowMissingLot();
    }

    @Test
    public void onButtonPressedSaveReserverMissingCodeTest() {
        Mockito.when(view.getParkingLot()).thenReturn(String.valueOf(PARKING_LOT));
        Mockito.when(view.getParkingCode()).thenReturn(EMPTY_STRING);
        presenter.setReservation(getStartCalendar(), true);
        presenter.setReservation(getEndCalendar(), false);
        presenter.onButtonPressedSaveReserver();
        verify(view).toastShowMissingCode();
    }

    @Test
    public void onButtonPressedSaveReserverOverlapTest() {
        ParkingDatabase.getInstance().setParkingLots(PARKING_LOTS);
        model.addReservation(getOverlapReservation());
        Mockito.when(view.getParkingLot()).thenReturn(String.valueOf(PARKING_LOT));
        Mockito.when(view.getParkingCode()).thenReturn(String.valueOf(USER_CODE));
        presenter.setReservation(getStartCalendar(), true);
        presenter.setReservation(getEndCalendar(), false);
        presenter.onButtonPressedSaveReserver();
        verify(view).toastShowOverlap();
    }

    private Calendar getStartCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, YEAR);
        calendar.set(Calendar.MONTH, MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, DAY_START);
        calendar.set(Calendar.HOUR, HOUR);
        calendar.set(Calendar.MINUTE, MINUTE);
        calendar.set(Calendar.SECOND, ZERO);
        calendar.set(Calendar.MILLISECOND, ZERO);
        return calendar;
    }

    private Calendar getEndCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, YEAR);
        calendar.set(Calendar.MONTH, MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, DAY_END);
        calendar.set(Calendar.HOUR, HOUR);
        calendar.set(Calendar.MINUTE, MINUTE);
        calendar.set(Calendar.SECOND, ZERO);
        calendar.set(Calendar.MILLISECOND, ZERO);
        return calendar;
    }

    private String getStringDate(Calendar calendar) {
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
        String dateToString = EMPTY_STRING;
        try {
            dateToString = simpleDateFormat.format(date);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return dateToString;
    }

    private Reservation getOverlapReservation() {
        Reservation reservation = new Reservation();
        Calendar startDate = getStartCalendar();
        startDate.set(Calendar.DAY_OF_MONTH, END_DAY_START_OVERLAP);
        reservation.setStartDate(startDate);
        Calendar endDate = getEndCalendar();
        endDate.set(Calendar.DAY_OF_MONTH, END_DAY_OVERLAP);
        reservation.setEndDate(endDate);
        reservation.setParkingLot(PARKING_LOT);
        reservation.setUserCode(USER_CODE);
        return reservation;
    }
}
