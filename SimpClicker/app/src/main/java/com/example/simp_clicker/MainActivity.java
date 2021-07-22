package com.example.simp_clicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.simp_clicker.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    Integer num=0;

    Workstation Twitch_A = new Workstation("Twitch Account",500,1,0);
    Workstation upgrade_Up = new Workstation("Upgrade",100,1,1);
    Workstation allWork[] = new Workstation[2];
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        loop();
    }
    void updateText(String text){
        this.runOnUiThread(new Runnable() {
            public void run() {
                TextView pView = (TextView) findViewById(R.id.point);
                pView.setText(text);
            }
        });
    }
    protected void loop(){
        TextView pView = (TextView) findViewById(R.id.point);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Integer tempnum = num;
                num+=Twitch_A.getAllPps();
                if(tempnum!=num){
                  updateText(num.toString());
                }
            }
        },0,1000);
    Button upgrade  =(Button) findViewById(R.id.upgrade_but);
        upgrade.setText("Upgrade: Cost: "+upgrade_Up.getCost());
        upgrade.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(num>=upgrade_Up.getCost()){
                num -= upgrade_Up.getCost();
                upgrade_Up.setCost();
                upgrade.setText("Upgrade: Cost: "+upgrade_Up.getCost());
                upgrade_Up.setAmount();
                upgrade_Up.setAllPps();
                pView.setText(num.toString());}
        }
    });
    ImageButton imgbut = (ImageButton)findViewById(R.id.imageButton);

       imgbut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            upgrade_Up.setAllPps();
            num = num+1*upgrade_Up.getAllPps();
            pView.setText(num.toString());
        }
    });

    Button Work1 = (Button)findViewById(R.id.work_one_but);
        Work1.setText("Twitch Account: Cost: "+Twitch_A.getCost());
        Work1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(num>=Twitch_A.getCost()) {
                num-=Twitch_A.getCost();
                Twitch_A.setAmount();
                Twitch_A.setAllPps();
                Twitch_A.setCost();
                Work1.setText("Twitch Account: Cost: "+Twitch_A.getCost());
                pView.setText(num.toString());
            }
        }
    });
}

}