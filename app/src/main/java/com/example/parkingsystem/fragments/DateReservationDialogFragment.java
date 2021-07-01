package com.example.parkingsystem.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.example.parkingsystem.databinding.FragmentDialogDatePickerBinding;

public class DateReservationDialogFragment extends DialogFragment {

    public static DateReservationDialogFragment newInstance() {
        return new DateReservationDialogFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        FragmentDialogDatePickerBinding binding = FragmentDialogDatePickerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
