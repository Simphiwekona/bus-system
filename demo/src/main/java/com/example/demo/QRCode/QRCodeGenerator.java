package com.example.demo.QRCode;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
//    private String QRCODE_PATH="C:\\Users\\LwethuBlack\\Desktop\\bus-system\\Storage\\";

    public JSONObject generateQRCode(String url) throws WriterException, IOException, JSONException {
//        String qrcode=QRCODE_PATH+"-QRCODE.png";
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix=writer.encode(url, BarcodeFormat.QR_CODE, 350, 350 );
//        Path path= FileSystems.getDefault().getPath(qrcode);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        byte[] imageData = outputStream.toByteArray();
        JSONObject json =new JSONObject();
        json.put("image",java.util.Base64.getEncoder().encodeToString(imageData));
        return json;
    }

}