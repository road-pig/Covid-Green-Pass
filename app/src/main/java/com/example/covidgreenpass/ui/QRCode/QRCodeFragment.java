package com.example.covidgreenpass.ui.QRCode;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.covidgreenpass.MainActivity;
import com.example.covidgreenpass.R;
import com.example.covidgreenpass.model.QRCode.eQRCode;
import com.example.covidgreenpass.model.User.Users;


import java.io.File;
import java.nio.file.Paths;

public class QRCodeFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_qrcode, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView qrCodeImage = view.findViewById(R.id.qrCodeImageView);

        String filename = "./" + Paths.get("./").toAbsolutePath().relativize(Paths.get(getActivity().getFilesDir().getAbsolutePath())) + "/" + "current" + ".png";

        File image = new File(filename);
        if (!image.exists()) {
            eQRCode qrCode = new eQRCode(300, 300, Users.loggedInUser);
            qrCode.generate((MainActivity) getActivity());
        }
        qrCodeImage.setImageURI(Uri.fromFile(image));
    }

}