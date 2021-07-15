package com.example.parkingsystem.mvp.presenter;


import com.example.parkingsystem.listener.ListenerDialogFragment;
import com.example.parkingsystem.mvp.contract.DialogSpaceParkingContract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class DialogSpaceParkingPresenterTest {
    private static final int PARKING_LOT = 5;
    DialogSpaceParkingContract.DialogFragmentPresenter presenter;
    @Mock
    DialogSpaceParkingContract.DialogFragmentView view;
    @Mock
    ListenerDialogFragment listenerDialogFragment;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new DialogSpaceParkingPresenter(view);
    }

    @Test
    public void onSaveButtonPressedTest() {
        Mockito.when(view.getSpacesFromEditText()).thenReturn(String.valueOf(PARKING_LOT));
        presenter.onSaveButtonPressed(this.listenerDialogFragment);
        Integer number = Integer.valueOf(view.getSpacesFromEditText());
        verify(listenerDialogFragment).setAmountParkingSpaces(number);
        verify(view).dismissDialogFragment();
    }
}
