package com.example.simp_clicker;

import android.os.Bundle;

import com.example.simp_clicker.ui.Data;
import com.example.simp_clicker.ui.Workstation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.simp_clicker.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Timer timer= new Timer();
        Data.addStationToList();
        //UI Update timer
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                UpdateText();
            }
        },0,1);


        //This is how the bottom bar controls and works
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);

        //First Workstation Timer, its not final
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Data.numOfPoints += Data.Work1.getTotalPps();

            }
        },0,1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Data.numOfPoints += Data.Work2.getTotalPps();

            }
        },0,1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Data.numOfPoints += Data.Work3.getTotalPps();

            }
        },0,1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Data.numOfPoints += Data.Work4.getTotalPps();

            }
        },0,1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Data.numOfPoints += Data.Work5.getTotalPps();

            }
        },0,1000);

    }
void UpdateText(){
    this.runOnUiThread(new Runnable() {
        public void run() {
            getSupportActionBar().setTitle(Data.numOfPoints.toString()+" SP");
            getSupportActionBar().setSubtitle(Data.getTotalWorkPps().toString()+" SP per second");
        }
    });
}
}