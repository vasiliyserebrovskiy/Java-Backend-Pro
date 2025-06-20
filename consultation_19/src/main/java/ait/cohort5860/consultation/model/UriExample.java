package ait.cohort5860.consultation.model;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (19.06.2025)
 */
public class UriExample {
    public static void main(String[] args) {

       // "https://www.example.com:8080/api/v1/users?search=query&sort=desc"

        String string = "https://www.example.com:8080/api/v1/users?search=query&sort=desc";

        URI url = URI.create(string);
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        System.out.println(url.getPort());

        URI uri2 = UriComponentsBuilder.fromHttpUrl("https://example.com/api/v1")
                .queryParam("sort", "desc")
                .queryParam("limit", "10")
                .build()
                .toUri();

    }
}
