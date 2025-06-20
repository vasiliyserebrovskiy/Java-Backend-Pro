package ait.imaga.colors;

import ait.imaga.colors.dto.ColorsResponseDto;
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
public class ImaggaColorsAppl {
    public static void main(String[] args) {

        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";
        String headerValue = args[0];
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", headerValue);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/colors")
                .queryParam("image_url", imgUrl);

        URI url = builder.build().toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<ColorsResponseDto> response = restTemplate.exchange(request, ColorsResponseDto.class);

        //Print our result in correct format

        System.out.println("  color name  | parent color name |  coverage percent  ");
        System.out.println("background_colors:");
        response.getBody().getResult().getColors().getBackgroundColors().forEach(System.out::println);
        System.out.println("foreground_colors:");
        response.getBody().getResult().getColors().getForegroundColors().forEach(System.out::println);
        System.out.println("image_colors:");
        response.getBody().getResult().getColors().getImageColors().forEach(System.out::println);

    }
}
