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
import com.example.covidgreenpass.model.User.Users;

public class ProfileFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        Button updateDetailsButton = root.findViewById(R.id.profileUpdate);
        TextView profileName = root.findViewById(R.id.profileName);
        TextView profileID = root.findViewById(R.id.profileID);
        TextView profileVaccineName = root.findViewById(R.id.profileVaccineName);
        TextView profileVaccinationDate = root.findViewById(R.id.profileVaccinationDate);
        TextView profileTestResult = root.findViewById(R.id.profileTestResult);
        TextView profileTestDate = root.findViewById(R.id.profileTestDate);
        TextView profileContactNumber = root.findViewById(R.id.profileContactNumber);
        TextView profileAddress = root.findViewById(R.id.addressTextView);

        profileName.setText(Users.loggedInUser.getName());
        profileVaccineName.setText(Users.loggedInUser.getVaccine());
        profileID.setText(Users.loggedInUser.getID());
        profileVaccinationDate.setText(Users.loggedInUser.getVaccineDate());
        profileTestResult.setText(Users.loggedInUser.getTestResult());
        profileTestDate.setText(Users.loggedInUser.getTestDate());
        profileAddress.setText(Users.loggedInUser.getAddress());
        profileContactNumber.setText(Users.loggedInUser.getContactNo());

        updateDetailsButton.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_navigation_profile_to_editDetailsFragment);
        });
        return root;
    }
}