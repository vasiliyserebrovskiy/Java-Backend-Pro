package ait.car.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.06.2025)
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class CarDto {
    private String manufacturer;
    private int year;
    private List<String> models;


}
