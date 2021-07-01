package com.example.parkingsystem.mvp.view;

import com.example.parkingsystem.databinding.FragmentDialogSpaceParkingBinding;
import com.example.parkingsystem.fragments.SpacesParkingDialogFragment;
import com.example.parkingsystem.mvp.contract.DialogSpaceParkingContract;
import com.example.parkingsystem.mvp.view.base.FragmentView;

public class DialogSpaceParkingView extends FragmentView implements DialogSpaceParkingContract.DialogFragmentView {
    private FragmentDialogSpaceParkingBinding binding;

    public DialogSpaceParkingView(FragmentDialogSpaceParkingBinding binding, SpacesParkingDialogFragment spacesParkingDialogFragment) {
        super(spacesParkingDialogFragment);
        this.binding = binding;
    }

    public String getSpacesFromEditText() {
        return binding.editTextDialogFragmentSpaces.getText().toString();
    }

    @Override
    public void dismissDialogFragment() {
        SpacesParkingDialogFragment dialogFragmentReference = (SpacesParkingDialogFragment) getFragment();
        if (dialogFragmentReference != null) {
            dialogFragmentReference.dismiss();
        }
    }
}
