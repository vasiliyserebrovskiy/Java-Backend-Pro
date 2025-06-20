package ait.car;

import ait.car.dto.CarDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.06.2025)
 */
public class CarCreationAppl {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CarDto vw = new CarDto("VW", 2020, List.of("Golf", "Polo", "Passat"));
        mapper.writeValue(new File("vw.json"), vw);

    }
}
