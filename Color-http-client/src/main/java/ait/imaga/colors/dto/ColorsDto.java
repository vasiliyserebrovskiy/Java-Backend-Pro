package ait.imaga.colors.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.06.2025)
 */
@Getter
public class ColorsDto {
    @JsonProperty("background_colors")
    private List<ColorInfo> backgroundColors;

    @JsonProperty("foreground_colors")
    private List<ColorInfo> foregroundColors;

    @JsonProperty("image_colors")
    private List<ColorInfo> imageColors;

    @JsonProperty("color_percent_threshold")
    private double colorPercentThreshold;

    @JsonProperty("color_variance")
    private int colorVariance;

    @JsonProperty("object_percentage")
    private double objectPercentage;
}
