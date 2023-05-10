package com.hdv.hdv;


//import org.springframework.core.io.FileSystemResource;
//        import org.springframework.http.HttpEntity;
//        import org.springframework.http.HttpHeaders;
//        import org.springframework.http.MediaType;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.util.LinkedMultiValueMap;
//        import org.springframework.util.MultiValueMap;
//        import org.springframework.web.client.RestTemplate;
//
//        import java.io.File;
//        import java.util.Collections;
//
//public class testLoadImg {
//
//    private static final String IMGUR_CLIENT_ID = "32d16cf269408a1";
//
//    public static void main(String[] args) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        headers.set("Authorization", "Client-ID " + IMGUR_CLIENT_ID);
//
//        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//        body.add("image", new FileSystemResource(new File("D:\\android\\FoodOn_FoodDelivery_by_Androrealm\\app\\src\\main\\res\\drawable\\bghome2.jpg")));
//
//        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
//
//        ResponseEntity<String> response = restTemplate.postForEntity(
//                "https://api.imgur.com/3/image",
//                requestEntity,
//                String.class
//        );
//
//        if (response.getStatusCode().is2xxSuccessful()) {
//            String responseJson = response.getBody();
//            System.out.println(responseJson);
//        } else {
//            System.out.println("Error uploading image: " + response.getStatusCode());
//        }
//    }
//}


import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

public class testLoadImg {

    private static final String IMGUR_CLIENT_ID = "32d16cf269408a1";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Client-ID " + IMGUR_CLIENT_ID);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", new FileSystemResource(new File("C:\\Users\\Admin\\Desktop\\logo.png")));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<ImgurResponse> responseEntity =
                restTemplate.exchange("https://api.imgur.com/3/image", HttpMethod.POST, requestEntity, ImgurResponse.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            ImgurResponse imgurResponse = responseEntity.getBody();
            String imageUrl = imgurResponse.getData().getLink();
            System.out.println("Image uploaded successfully. URL: " + imageUrl);
        } else {
            System.out.println("Error uploading image: " + responseEntity.getStatusCode().getReasonPhrase());
        }
    }

    public static class ImgurResponse {
        private boolean success;
        private int status;
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

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public static class Data {
            private String id;
            private String title;
            private String description;
            private String link;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }
    }
}
