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
import com.example.simp_clicker.ui.Workstation;

public class ShopFragment extends Fragment {

    private ShopViewModel shopViewModel;
    private FragmentDashboardBinding binding;

    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        shopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Workstations Buttons put them below here:
        setupButtonWorkButtons(root, R.id.Work1_id, Data.Work1);
        setupButtonWorkButtons(root, R.id.Work2_id, Data.Work2);
        setupButtonWorkButtons(root, R.id.Work3_id, Data.Work3);
        setupButtonWorkButtons(root, R.id.Work4_id, Data.Work4);
        setupButtonWorkButtons(root, R.id.Work5_id, Data.Work5);

        return root;
    }

    private void setupButtonWorkButtons(View root, int WorkId, Workstation work){
        Button WorkButton = (Button)root.findViewById(WorkId);
        WorkButton.setText(work.getName() + " Cost: " + work.getCost());
        WorkButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Data.numOfPoints>=work.getCost())  // Check if there are enough points
                {

                    Data.numOfPoints -=work.getCost();  // Removes the points used from the total
                    work.setCost(2);                     // Adds 20% to the cost, other numbers from 1-10 works as well
                    work.addAmount(1);
                    WorkButton.setText(work.getName() + " Cost: " + work.getCost());
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}