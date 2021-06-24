package com.example.parkingsystem.mvp.contract;

import com.example.parkingsystem.listener.ListenerDialogFragment;

public interface DialogSpaceParkingContract {

    interface DialogFragmentPresenter {
        void onSaveButtonPressed(ListenerDialogFragment listenerDialogFragment);
    }

    interface DialogFragmentView {
        String getSpacesFromEditText();
        void dismissDialogFragment();
    }
}
