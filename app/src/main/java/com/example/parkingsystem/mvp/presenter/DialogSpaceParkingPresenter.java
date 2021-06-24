package com.example.parkingsystem.mvp.presenter;

import com.example.parkingsystem.listener.ListenerDialogFragment;
import com.example.parkingsystem.mvp.contract.DialogSpaceParkingContract;

public class DialogSpaceParkingPresenter implements DialogSpaceParkingContract.DialogFragmentPresenter {
    private DialogSpaceParkingContract.DialogFragmentView view;

    public DialogSpaceParkingPresenter(DialogSpaceParkingContract.DialogFragmentView view) {
        this.view = view;
    }

    @Override
    public void onSaveButtonPressed(ListenerDialogFragment listenerDialogFragment) {
        Integer number = Integer.valueOf(view.getSpacesFromEditText());
        listenerDialogFragment.setAmountParkingSpaces(number);
        view.dismissDialogFragment();
    }
}
