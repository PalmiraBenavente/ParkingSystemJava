package com.example.parkingsystem.mvp.view;

import com.example.parkingsystem.databinding.FragmentDialogDatePickerBinding;
import com.example.parkingsystem.fragments.DateReservationDialogFragment;
import com.example.parkingsystem.listener.ListenerDialogFragmentDate;
import com.example.parkingsystem.mvp.contract.DialogDateResarvationContract;
import com.example.parkingsystem.mvp.view.base.FragmentView;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DialogDateResarvationView extends FragmentView implements DialogDateResarvationContract.DialogFragmentDateReservationView {
    private FragmentDialogDatePickerBinding binding;

    public DialogDateResarvationView(FragmentDialogDatePickerBinding binding, DateReservationDialogFragment fragment) {
        super(fragment);
        this.binding = binding;
    }

    @Override
    public void setDateTime(ListenerDialogFragmentDate listenerDialogFragmentDate, boolean startDatePicker) {
        listenerDialogFragmentDate.setDateTime(getCalendarDateTime(), startDatePicker);
    }

    private Calendar getCalendarDateTime() {
        Calendar extractDateTime = new GregorianCalendar();
        extractDateTime.set(binding.datePickerDialogFragment.getYear(),
                binding.datePickerDialogFragment.getMonth(),
                binding.datePickerDialogFragment.getDayOfMonth(),
                binding.timePickerDialogFragment.getHour(),
                binding.timePickerDialogFragment.getMinute());
        return extractDateTime;
    }

    @Override
    public void dismissPicker() {
        DateReservationDialogFragment dialogFragmentReference = (DateReservationDialogFragment) getFragment();
        if (dialogFragmentReference != null) {
            dialogFragmentReference.dismiss();
        }
    }
}
