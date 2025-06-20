package ait.immaga.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.06.2025)
 */
@Getter
@ToString
public class TagDto {
    private double confidence;
    private Map<String, String> tag;

}
