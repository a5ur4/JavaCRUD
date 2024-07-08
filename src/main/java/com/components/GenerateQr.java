package com.components;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

public class GenerateQr {
    public static void generateQrCode(String data, String path, String charset) 
    throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(
            new String(data.getBytes(charset), charset),
            BarcodeFormat.QR_CODE, 200, 200);

        Path outputPath = Paths.get(path);

        Files.createDirectories(outputPath.getParent());

        MatrixToImageWriter.writeToPath(matrix,
            path.substring(path.lastIndexOf('.') + 1),
            outputPath);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Creating QR Code...");

            String projectDir = System.getProperty("user.dir");

            String resourcesPath = projectDir + "/src/main/resources/test.png";

            generateQrCode("testando", resourcesPath, "UTF-8");
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}
