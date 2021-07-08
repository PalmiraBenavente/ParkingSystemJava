package com.example.parkingsystem.mvp.contract;

import com.example.parkingsystem.listener.ListenerDialogFragmentDate;

public interface DialogDateResarvationContract {

    interface DialogFragmentDateReservationPresenter {
        void onOkButtonPressed(ListenerDialogFragmentDate listenerDialogFragmentDate);
        void onCancelButtonPressed();
    }
    interface DialogFragmentDateReservationView { ;
        void setDateTime(ListenerDialogFragmentDate listenerDialogFragmentDate, boolean startDatePicker);
        void dismissPicker();
    }
}
