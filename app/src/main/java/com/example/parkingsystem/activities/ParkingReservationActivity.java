package com.example.parkingsystem.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystem.databinding.ActivityReserverParkingLotBinding;
import com.example.parkingsystem.mvp.contract.ReservationParkingContract;
import com.example.parkingsystem.mvp.presenter.ReservationParkingPresenter;
import com.example.parkingsystem.mvp.view.ReservationParkingView;

public class ParkingReservationActivity extends AppCompatActivity {

    ActivityReserverParkingLotBinding binding;
    ReservationParkingContract.ReservationActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReserverParkingLotBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new ReservationParkingPresenter(new ReservationParkingView(this));
        this.setListener();
    }

    private void setListener() {
        this.binding.buttonReserverParkingPickerInic.setOnClickListener(view -> presenter.onButtonPressedSelectReserver());
        this.binding.buttonReserverParkingPickerEnd.setOnClickListener(view -> presenter.onButtonPressedSelectReserver());
    }

    public static Intent newInstance(Context context) {
        return new Intent(context, ParkingReservationActivity.class);
    }
}
