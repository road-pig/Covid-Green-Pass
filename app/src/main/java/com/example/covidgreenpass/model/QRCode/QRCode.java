package com.example.covidgreenpass.model.QRCode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

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

    protected void generateQRCodeImage(String text, String filename) throws WriterException, IOException{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath("./" + filename);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

}
