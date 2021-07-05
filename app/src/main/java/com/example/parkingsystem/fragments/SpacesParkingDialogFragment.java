package com.example.parkingsystem.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.example.parkingsystem.databinding.FragmentDialogSpaceParkingBinding;
import com.example.parkingsystem.listener.ListenerDialogFragment;
import com.example.parkingsystem.mvp.contract.DialogSpaceParkingContract;
import com.example.parkingsystem.mvp.presenter.DialogSpaceParkingPresenter;
import com.example.parkingsystem.mvp.view.DialogSpaceParkingView;

public class SpacesParkingDialogFragment extends DialogFragment {

    private FragmentDialogSpaceParkingBinding binding;
    private DialogSpaceParkingContract.DialogFragmentPresenter presenter;
    private ListenerDialogFragment listenerDialogFragment;

    public SpacesParkingDialogFragment() {
    }

    public static SpacesParkingDialogFragment newInstance() {
        SpacesParkingDialogFragment dialogFragment = new SpacesParkingDialogFragment();
        return dialogFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listenerDialogFragment = (ListenerDialogFragment) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDialogSpaceParkingBinding.inflate(getLayoutInflater());
        presenter = new DialogSpaceParkingPresenter(new DialogSpaceParkingView(binding, this));
        setListener();
        return binding.getRoot();
    }

    private void setListener() {
        binding.buttonDialogFragmentOk.setOnClickListener(view -> presenter.onSaveButtonPressed(listenerDialogFragment));
    }
}
