package com.example.demo;

import com.example.demo.QRCode.QRCodeGenerator;
import com.google.zxing.WriterException;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException, WriterException, JSONException {

		SpringApplication.run(DemoApplication.class, args);
		try {
			QRCodeGenerator codeGenerator = new QRCodeGenerator();
			JSONObject json = codeGenerator.generateQRCode("https://jumpco.io/");

			System.out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
