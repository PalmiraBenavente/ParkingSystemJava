package com.example.parkingsystem.mvp.presenter;

import com.example.parkingsystem.listener.ListenerDialogFragmentDate;
import com.example.parkingsystem.mvp.contract.DialogDateResarvationContract;
import com.example.parkingsystem.mvp.view.DialogDateResarvationView;

public class DialogDateResarvationPresenter implements DialogDateResarvationContract.DialogFragmentDateReservationPresenter {
    private DialogDateResarvationContract.DialogFragmentDateReservationView view;
    private boolean startDatePicker;

    public DialogDateResarvationPresenter(DialogDateResarvationView view, boolean startDatePicker) {
        this.view = view;
        this.startDatePicker = startDatePicker;
    }

    @Override
    public void onOkButtonPressed(ListenerDialogFragmentDate listenerDialogFragmentDate) {
        view.setDateTime(listenerDialogFragmentDate, this.startDatePicker);
        view.dismissPicker();
    }

    @Override
    public void onCancelButtonPressed() {
        view.dismissPicker();
    }
}
