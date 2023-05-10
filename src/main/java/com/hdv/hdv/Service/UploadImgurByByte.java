package com.hdv.hdv.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class UploadImgurByByte {

    private static final String IMGUR_CLIENT_ID = "32d16cf269408a1";

//    public static void main(String[] args) {
//        byte[] imageData;
//        try {
//            imageData = Files.readAllBytes(Paths.get("C:\\Users\\Admin\\Desktop\\logo.png"));
//            String imageBase64 = Base64.getEncoder().encodeToString(imageData);
//            String imageUrl = uploadImageToImgur(imageBase64);
//            System.out.println("Image uploaded successfully. URL: " + imageUrl);
//        } catch (IOException e) {
//            System.out.println("Error reading image file: " + e.getMessage());
//        }
//    }

    public static String getLink(byte[] bytes)
    {
        byte[] imageData = bytes;
        try {
            imageData = Files.readAllBytes(Paths.get("C:\\Users\\Admin\\Desktop\\logo.png"));
            String imageBase64 = Base64.getEncoder().encodeToString(imageData);
            String imageUrl = uploadImageToImgur(imageBase64);
            System.out.println("Image uploaded successfully. URL: " + imageUrl);
            return imageUrl;
        } catch (IOException e) {
            System.out.println("Error reading image file: " + e.getMessage());
        }
        return null;
    }

    public static String uploadImageToImgur(String imageBase64) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("Authorization", "Client-ID " + IMGUR_CLIENT_ID);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", imageBase64);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ImgurResponse> responseEntity = restTemplate.postForEntity(
                "https://api.imgur.com/3/image", requestEntity, ImgurResponse.class);

        ImgurResponse imgurResponse = responseEntity.getBody();

        if (imgurResponse.isSuccess()) {
            return imgurResponse.getData().getLink();
        } else {
            throw new IOException("Failed to upload image: " + imgurResponse.getStatus() + " " + imgurResponse.getError());
        }
    }

    public static class ImgurResponse {
        private boolean success;
        private int status;
        private String error;
        private Data data;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    public static class Data {
        private String link;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
