package com.example.simp_clicker.ui.dashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.simp_clicker.R;
import com.example.simp_clicker.databinding.FragmentDashboardBinding;
import com.example.simp_clicker.ui.Data;

public class ShopFragment extends Fragment {

    private ShopViewModel shopViewModel;
    private FragmentDashboardBinding binding;

    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shopViewModel =
                new ViewModelProvider(this).get(ShopViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        // Workstations Buttons put them below here:
        Button Work1But = (Button)root.findViewById(R.id.Work1_id);
        Work1But.setText(Data.Work1.getName() + " Cost: " + Data.Work1.getCost());
        Work1But.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Data.numOfPoints>=Data.Work1.getCost())  // Check if there are enough points
                {

                    Data.numOfPoints -=Data.Work1.getCost();  // Removes the points used from the total
                    Data.Work1.setCost(2);                     // Adds 20% to the cost, other numbers from 1-10 works as well
                    Data.Work1.addAmount(1);
                    Work1But.setText(Data.Work1.getName() + " Cost: " + Data.Work1.getCost());
                    // Would it be smart to, instead of using set cost, just calculate the cost based on how many workstations of that type have already been purchased?
                    // This way if there are other ways of acquiring workstations or if we want to add multipliers to cost later it would be much easier
                    // note on this note
                    // I have been trying to implement this feature, but keep running into bugs, so if you find a suitable solution, please implement it
                }

            }
        });
        Button Work2But = (Button)root.findViewById(R.id.Work2_id);
        Work2But.setText(Data.Work2.getName() + " Cost: " + Data.Work2.getCost());
        Work2But.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Data.numOfPoints>=Data.Work2.getCost())  // Check if there are enough points
                {

                    Data.numOfPoints -=Data.Work2.getCost();  // Removes the points used from the total
                    Data.Work2.setCost(2);                     // Adds 20% to the cost, other numbers from 1-10 works as well
                    Data.Work2.addAmount(1);
                    Work2But.setText(Data.Work2.getName() + " Cost: " + Data.Work2.getCost());
                     }

            }
        });
        Button Work3But = (Button)root.findViewById(R.id.Work3_id);
        Work3But.setText(Data.Work3.getName() + " Cost: " + Data.Work3.getCost());
        Work3But.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Data.numOfPoints>=Data.Work3.getCost())  // Check if there are enough points
                {

                    Data.numOfPoints -=Data.Work3.getCost();  // Removes the points used from the total
                    Data.Work3.setCost(2);                     // Adds 20% to the cost, other numbers from 1-10 works as well
                    Data.Work3.addAmount(1);
                    Work3But.setText(Data.Work3.getName() + " Cost: " + Data.Work3.getCost());
                     }

            }
        });
        Button Work4But = (Button)root.findViewById(R.id.Work4_id);
        Work4But.setText(Data.Work4.getName() + " Cost: " + Data.Work4.getCost());
        Work4But.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Data.numOfPoints>=Data.Work4.getCost())  // Check if there are enough points
                {

                    Data.numOfPoints -=Data.Work4.getCost();  // Removes the points used from the total
                    Data.Work4.setCost(2);                     // Adds 20% to the cost, other numbers from 1-10 works as well
                    Data.Work4.addAmount(1);
                    Work4But.setText(Data.Work4.getName() + " Cost: " + Data.Work4.getCost());
                          }

            }
        });
        Button Work5But = (Button)root.findViewById(R.id.Work5_id);
        Work5But.setText(Data.Work5.getName() + " Cost: " + Data.Work5.getCost());
        Work5But.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Data.numOfPoints>=Data.Work5.getCost())  // Check if there are enough points
                {

                    Data.numOfPoints -=Data.Work5.getCost();  // Removes the points used from the total
                    Data.Work5.setCost(2);                     // Adds 20% to the cost, other numbers from 1-10 works as well
                    Data.Work5.addAmount(1);
                    Work5But.setText(Data.Work5.getName() + " Cost: " + Data.Work5.getCost());
                }

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}