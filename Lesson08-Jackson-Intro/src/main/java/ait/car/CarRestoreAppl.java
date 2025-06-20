package ait.car;

import ait.car.dto.CarDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.06.2025)
 */
public class CarRestoreAppl {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CarDto carVW = mapper.readValue(new File("vw.json"), CarDto.class); //while restore object work through reflection
        System.out.println(carVW);

    }
}
