package com.example.parkingsystem.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.example.parkingsystem.R;
import com.example.parkingsystem.SpacesParkingDialogFragment;
import com.example.parkingsystem.databinding.ActivityMainBinding;
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
        Context context = getContext();
        if (context != null)
            Toast.makeText(context, context.getString(R.string.toast_main_activity_select_space_parking, parkingSpace), Toast.LENGTH_SHORT).show();
    }
}
