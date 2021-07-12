package com.example.parkingsystem.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parkingsystem.database.ParkingDatabase;
import com.example.parkingsystem.databinding.ActivityMainBinding;
import com.example.parkingsystem.listener.ListenerDialogFragment;
import com.example.parkingsystem.mvp.contract.ParkingContract;
import com.example.parkingsystem.mvp.model.ParkingModel;
import com.example.parkingsystem.mvp.presenter.ParkingPresenter;
import com.example.parkingsystem.mvp.view.ParkingView;

public class MainActivity extends AppCompatActivity implements ListenerDialogFragment {
    private ActivityMainBinding binding;
    private ParkingContract.MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new ParkingPresenter(new ParkingModel(ParkingDatabase.getInstance()), new ParkingView(this, this.binding));
        this.setListener();
    }

    private void setListener() {
        this.binding.buttonMainSelectParking.setOnClickListener(view -> presenter.onSelectParkingButtonPressed());
        this.binding.buttonMainBookParkingSpaces.setOnClickListener(view -> presenter.onBookParkingSpaces());
        this.binding.buttonMainRemoveOldParkingSpaces.setOnClickListener(view -> presenter.onRemovedOldReservation());
    }

    @Override
    public void setAmountParkingSpaces(int spaces) {
        presenter.onSetParkingButtonPressed(spaces);
    }
}
