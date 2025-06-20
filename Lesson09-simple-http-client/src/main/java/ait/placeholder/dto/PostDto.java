package ait.placeholder.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.06.2025)
 */

@Getter
@ToString
@EqualsAndHashCode(of = {"id"})

public class PostDto {
    private int userId;
    private int id;
    private String title;
    private String body;
}
