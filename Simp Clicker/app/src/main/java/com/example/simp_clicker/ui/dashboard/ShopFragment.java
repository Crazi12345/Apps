package com.example.simp_clicker.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.simp_clicker.R;
import com.example.simp_clicker.databinding.FragmentDashboardBinding;
import com.example.simp_clicker.ui.Workstation;

import java.util.Timer;

public class ShopFragment extends Fragment {

    private ShopViewModel shopViewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shopViewModel =
                new ViewModelProvider(this).get(ShopViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Timer shopTimer = new Timer();
        Workstation Work1 = new Workstation("Twitch Account",50,1,0);
        final TextView textView = binding.textDashboard;
        Button Work1But = (Button)root.findViewById(R.id.TwatchAccount);
        Work1But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Work1.addAmount(1);
            }
        });
        shopViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText("s");
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