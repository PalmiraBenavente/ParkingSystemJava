package com.example.parkingsystem.mvp.presenter;

import com.example.parkingsystem.database.ParkingDatabase;
import com.example.parkingsystem.mvp.contract.ParkingContract;
import com.example.parkingsystem.mvp.model.ParkingModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class ParkingPresenterTest {

    private static final int PARKING_LOT = 5;
    private static final int INT_ZERO = 0;
    private ParkingContract.MainActivityPresenter presenter;
    private ParkingContract.MainActivityModel model;
    @Mock
    private ParkingContract.MainActivityView view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        model = new ParkingModel(ParkingDatabase.getInstance());
        presenter = new ParkingPresenter(model, view);
    }

    @Test
    public void onSelectParkingButtonPressedTest() {
        presenter.onSelectParkingButtonPressed();
        verify(view).showSelectionParkingSpaces();
    }

    @Test
    public void onSetParkingButtonPressedTest() {
        this.presenter.onSetParkingButtonPressed(PARKING_LOT);
        assertEquals(PARKING_LOT, model.getParkingSpace());
        verify(view).toastShowSpaces(PARKING_LOT);
    }

    @Test
    public void onBookParkingSpacesTest() {
        this.presenter.onBookParkingSpaces();
        assertEquals(INT_ZERO, model.removedOldReservation());
        verify(view).showBookParkingPickers();
    }

    @Test
    public void onRemovedOldReservationTest() {
        this.presenter.onRemovedOldReservation();
        assertEquals(INT_ZERO, model.removedOldReservation());
        verify(view).showToasRemovedReservation(model.removedOldReservation());
    }
}
