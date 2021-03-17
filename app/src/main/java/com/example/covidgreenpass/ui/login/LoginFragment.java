package com.example.covidgreenpass.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidgreenpass.R;
import com.example.covidgreenpass.model.User.Users;

public class LoginFragment extends Fragment {

//    private LoginViewModel loginViewModel;
//
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
//
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText usernameEditText = view.findViewById(R.id.username);
        final EditText passwordEditText = view.findViewById(R.id.password);
        final Button loginButton = view.findViewById(R.id.login);
        final ProgressBar loadingProgressBar = view.findViewById(R.id.loading);
        final TextView incorrectTextView = view.findViewById(R.id.loginIncorrect);

       loginButton.setOnClickListener(view1 -> {
           String username = usernameEditText.getText().toString();
           String password = passwordEditText.getText().toString();

           if(Users.login(username, password)){
               NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_navigation_qr_code);
           }else{
                incorrectTextView.setVisibility(View.VISIBLE);
           }
       });
    }
//
//    private void updateUiWithUser(LoggedInUserView model) {
//        String welcome = getString(R.string.welcome) + model.getDisplayName();
//        // TODO : initiate successful logged in experience
//        if (getContext() != null && getContext().getApplicationContext() != null) {
//            Toast.makeText(getContext().getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    private void showLoginFailed(@StringRes Integer errorString) {
//        if (getContext() != null && getContext().getApplicationContext() != null) {
//            Toast.makeText(
//                    getContext().getApplicationContext(),
//                    errorString,
//                    Toast.LENGTH_LONG).show();
//        }
//    }
}