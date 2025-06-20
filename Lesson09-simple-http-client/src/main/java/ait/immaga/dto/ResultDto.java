package ait.immaga.dto;

import lombok.Getter;

import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.06.2025)
 */
@Getter
public class ResultDto {
    private List<TagDto> tags; // Jackson can transform array to any iterable list,set
}
