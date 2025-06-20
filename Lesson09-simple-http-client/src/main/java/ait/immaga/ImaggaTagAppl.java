package ait.immaga;

import ait.immaga.dto.TagsResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.06.2025)
 */
public class ImaggaTagAppl {
    public static void main(String[] args) {
        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";
        String lang = "en";
        int threshold = 30;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWNjXzI4MTQyOTFjYzExODg2MTo0MzY3MDg3OGRlZTMyNzFjNDA0MWY2MGI3NTg1ZDk1MQ==");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/tags")
                .queryParam("image_url", imgUrl)
                .queryParam("language", lang)
                .queryParam("threshold", threshold);
        URI url = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<TagsResponseDto> response = restTemplate.exchange(request, TagsResponseDto.class);
        response.getBody().getResult().getTags().forEach(System.out::println);
    }
}
