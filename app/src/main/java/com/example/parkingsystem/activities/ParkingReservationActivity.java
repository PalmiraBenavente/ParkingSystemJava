package com.example.parkingsystem.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystem.database.ParkingDatabase;
import com.example.parkingsystem.databinding.ActivityReserverParkingLotBinding;
import com.example.parkingsystem.listener.ListenerDialogFragmentDate;
import com.example.parkingsystem.mvp.contract.ReservationParkingContract;
import com.example.parkingsystem.mvp.model.ReservationParkingModel;
import com.example.parkingsystem.mvp.presenter.ReservationParkingPresenter;
import com.example.parkingsystem.mvp.view.ReservationParkingView;
import com.example.parkingsystem.utils.ReservationChecker;
import java.util.Calendar;

public class ParkingReservationActivity extends AppCompatActivity implements ListenerDialogFragmentDate {

    ActivityReserverParkingLotBinding binding;
    ReservationParkingContract.ReservationActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReserverParkingLotBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new ReservationParkingPresenter(new ReservationParkingView(this, binding), new ReservationParkingModel(ParkingDatabase.getInstance(), new ReservationChecker(ParkingDatabase.getInstance())));
        this.setListener();
    }

    private void setListener() {
        this.binding.buttonReserverParkingPickerInic.setOnClickListener(view -> presenter.onButtonStartPressedSelectReserver());
        this.binding.buttonReserverParkingPickerEnd.setOnClickListener(view -> presenter.onButtonEndPressedSelectReserver());
        this.binding.buttonReserverParkingSave.setOnClickListener(view -> presenter.onButtonPressedSaveReserver());
    }

    public static Intent newInstance(Context context) {
        return new Intent(context, ParkingReservationActivity.class);
    }

    @Override
    public void setDateTime(Calendar calendarDateTime, boolean startDate) {
        presenter.setReservation(calendarDateTime, startDate);
    }
}
