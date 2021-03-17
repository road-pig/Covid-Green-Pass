package com.example.covidgreenpass.model.QRCode;



import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public abstract class QRCode {
    protected int width;
    protected int height;

    protected QRCode(int width, int height){
        this.width = width;
        this.height = height;
    }

    protected Bitmap generateQRCodeImage(String text, String filename) throws WriterException, IOException{
        BarcodeEncoder qrCodeWriter = new BarcodeEncoder();
        Bitmap bitmap = qrCodeWriter.encodeBitmap(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath("./" + filename);
        return bitmap;
    }

}
