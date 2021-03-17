package com.example.covidgreenpass.ui.profile;

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
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.covidgreenpass.R;

public class ProfileFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private Button updateDetailsButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        updateDetailsButton = root.findViewById(R.id.profileUpdate);
        updateDetailsButton.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_navigation_profile_to_editDetailsFragment);
        });
        return root;
    }
}