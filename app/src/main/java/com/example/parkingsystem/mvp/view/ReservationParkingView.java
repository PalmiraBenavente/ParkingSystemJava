package com.example.parkingsystem.mvp.view;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.example.parkingsystem.fragments.DateReservationDialogFragment;
import com.example.parkingsystem.mvp.contract.ReservationParkingContract;
import com.example.parkingsystem.mvp.view.base.ActivityView;

public class ReservationParkingView extends ActivityView implements ReservationParkingContract.ReservationActivityView {

    private final String DIALOG_FRAGMENT_DATE_PICKER = "dialog fragment date picker";

    public ReservationParkingView(Activity activity) {
        super(activity);
    }

    @Override
    public void showDialogDataPiker() {
        FragmentManager fragmentManager = getFragmentManager();
        DateReservationDialogFragment dateDialogFragment = DateReservationDialogFragment.newInstance();
        dateDialogFragment.show(fragmentManager, DIALOG_FRAGMENT_DATE_PICKER);
    }
}
