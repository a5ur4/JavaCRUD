package com.components;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadingQr {
    public static String readQr(String path) throws IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
            new BufferedImageLuminanceSource(
                ImageIO.read(new FileInputStream(path))
            )
        ));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        return result.getText();
    }

    public static void main(String[] args) {
        try {
            String projectDir = System.getProperty("user.dir");

            String resourcesPath = projectDir + "/src/main/resources/userQRCode.png";

            System.out.println("The data stored in the QR Code is: " + ReadingQr.readQr(resourcesPath));
            System.out.println("QR Code read successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
