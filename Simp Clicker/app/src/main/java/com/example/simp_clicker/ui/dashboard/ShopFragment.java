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
                    Data.Work1.addAmount(1);
                    Data.numOfPoints -=Data.Work1.getCost();  // Removes the points used from the total
                    Data.Work1.setCost();                     // Adds 20% to the cost
                    Work1But.setText(Data.Work1.getName() + " Cost: " + Data.Work1.getCost());
                    // Would it be smart to, instead of using set cost, just calculate the cost based on how many workstations of that type have already been purchased?
                    // This way if there are other ways of acquiring workstations or if we want to add multipliers to cost later it would be much easier
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