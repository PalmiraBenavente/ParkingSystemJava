package com.example.parkingsystem.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.example.parkingsystem.R;
import com.example.parkingsystem.activities.ParkingReservationActivity;
import com.example.parkingsystem.databinding.ActivityMainBinding;
import com.example.parkingsystem.fragments.SpacesParkingDialogFragment;
import com.example.parkingsystem.mvp.contract.ParkingContract;
import com.example.parkingsystem.mvp.view.base.ActivityView;

public class ParkingView extends ActivityView implements ParkingContract.MainActivityView {
    private final ActivityMainBinding binding;

    public ParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showSelectionParkingSpaces(int parkingSpace) {
        FragmentManager fragmentManager = getFragmentManager();
        SpacesParkingDialogFragment spacesParkingDialogFragment = SpacesParkingDialogFragment.newInstance();
        spacesParkingDialogFragment.show(fragmentManager, "dialog_fragment");
    }

    public void toastShowSpaces(int parkingSpace) {
        showToast(R.string.toast_main_activity_select_space_parking, parkingSpace);
    }

    @Override
    public void showBookParkingPickers() {
        Context context = getContext();
        Activity activity = getActivity();
        if (context != null && activity != null) {
            Intent intent = ParkingReservationActivity.newInstance(context);
            activity.startActivity(intent);
        }
    }

    @Override
    public void showToasRemovedReservation(int cantOldResevations) {
        showToast(R.string.toas_main_removed_old_reservations, cantOldResevations);
    }

    private void showToast(int messageId, int messageInt) {
        Activity activity = getActivity();
        if (activity != null) {
            Toast.makeText(activity, activity.getString(messageId, messageInt), Toast.LENGTH_SHORT).show();
        }
    }
}
