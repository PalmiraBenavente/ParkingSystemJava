package com.example.parkingsystem.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.example.parkingsystem.utils.Constants;
import com.example.parkingsystem.databinding.FragmentDialogDatePickerBinding;
import com.example.parkingsystem.listener.ListenerDialogFragmentDate;
import com.example.parkingsystem.mvp.contract.DialogDateResarvationContract;
import com.example.parkingsystem.mvp.presenter.DialogDateResarvationPresenter;
import com.example.parkingsystem.mvp.view.DialogDateResarvationView;

public class DateReservationDialogFragment extends DialogFragment {

    private FragmentDialogDatePickerBinding binding;
    private DialogDateResarvationContract.DialogFragmentDateReservationPresenter presenter;
    private ListenerDialogFragmentDate listenerDialogFragmentDate;

    public static DateReservationDialogFragment newInstance(boolean startDatePicker) {
        DateReservationDialogFragment dialog = new DateReservationDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.TAG_START_DATE, startDatePicker);
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listenerDialogFragmentDate = (ListenerDialogFragmentDate) getActivity();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentDialogDatePickerBinding.inflate(getLayoutInflater());
        this.presenter = new DialogDateResarvationPresenter(new DialogDateResarvationView(binding, this), getArguments().getBoolean(Constants.TAG_START_DATE));
        setListener();
        return binding.getRoot();
    }

    private void setListener() {
        this.binding.buttonReservationDialogFragmentConfirm.setOnClickListener(view -> this.presenter.onOkButtonPressed(this.listenerDialogFragmentDate));
        this.binding.buttonReservationDialogFragmentCancel.setOnClickListener(view -> this.presenter.onCancelButtonPressed());
    }
}
