package com.example.parkingsystem.mvp.presenter;

import com.example.parkingsystem.listener.ListenerDialogFragmentDate;
import com.example.parkingsystem.mvp.contract.DialogDateResarvationContract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class DialogDateReservationPresenterTest {
    DialogDateResarvationContract.DialogFragmentDateReservationPresenter presenter;
    @Mock
    DialogDateResarvationContract.DialogFragmentDateReservationView view;
    @Mock
    ListenerDialogFragmentDate listenerDialogFragmentDate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new DialogDateResarvationPresenter(view, true);
    }

    @Test
    public void onOkButtonPressedTestTrue() {
        presenter.onOkButtonPressed(listenerDialogFragmentDate);
        verify(view).setDateTime(listenerDialogFragmentDate, true);
        verify(view).dismissPicker();
    }

    @Test
    public void onCancelButtonPressedTest() {
        presenter.onCancelButtonPressed();
        verify(view).dismissPicker();
    }
}
