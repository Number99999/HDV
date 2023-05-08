package com.hdv.hdv;

import java.io.IOException;
import java.net.URL;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Base64;
public class testLoadImg {

    public static void main(String[] args) throws IOException {
        String clientId = "32d16cf269408a1"; // replace with your Imgur client ID
        String imageData = "<BASE_64_ENCODED_IMAGE_DATA>"; // replace with your base64-encoded image data

        URL url = new URL("https://api.imgur.com/3/image");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        conn.setRequestProperty("Authorization", "Client-ID " + clientId);

        String data = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imageData, "UTF-8");


        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write(data);
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String response = reader.readLine();
        reader.close();
        writer.close();

        System.out.println(response);
    }

    private static String encodeImageToBase64(String imagePath) throws IOException {
        File file = new File(imagePath);

        byte[] bytes = new byte[(int) file.length()];
        InputStream in = new FileInputStream(file);
        in.read(bytes);
        in.close();

        return Base64.getEncoder().encodeToString(bytes);
    }
}