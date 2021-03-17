package com.example.covidgreenpass.ui.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.covidgreenpass.R;
import com.example.covidgreenpass.model.User.User;
import com.example.covidgreenpass.model.User.Users;


public class EditDetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editTextPhone = view.findViewById(R.id.editTextPhone);
        EditText editTextAddress = view.findViewById(R.id.editTextTextPostalAddress);
        EditText editTextPassword = view.findViewById(R.id.password);
        EditText editTextConfirmPassword = view.findViewById(R.id.editTextConfirmPassword);
        TextView doesNotMatch = view.findViewById(R.id.editPasswordsMatch);
        Button editConfirm = view.findViewById(R.id.editConfirm);

        editTextAddress.setText(Users.loggedInUser.getAddress());
        editTextPhone.setText(Users.loggedInUser.getContactNo());
        editTextConfirmPassword.setText(Users.loggedInUser.getPassword());
        editTextPassword.setText(Users.loggedInUser.getPassword());

        editTextConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editTextConfirmPassword.getText().toString().equals(editTextPassword.getText().toString())){
                    doesNotMatch.setVisibility(View.GONE);
                    editConfirm.setActivated(true);
                }else{
                    doesNotMatch.setVisibility(View.VISIBLE);
                    editConfirm.setActivated(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editTextConfirmPassword.getText().toString().equals(editTextPassword.getText().toString())){
                    doesNotMatch.setVisibility(View.GONE);
                    editConfirm.setActivated(true);
                }else{
                    doesNotMatch.setVisibility(View.VISIBLE);
                    editConfirm.setActivated(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editConfirm.setOnClickListener(view1 -> {
            Users.loggedInUser.setContactNo(editTextPhone.getText().toString());
            Users.loggedInUser.setAddress(editTextAddress.getText().toString());
            Users.loggedInUser.setPassword(editTextPassword.getText().toString());
            NavHostFragment.findNavController(this).navigate(R.id.action_editDetailsFragment_to_navigation_profile);
        });
    }
}