package ait.imaga.colors.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.06.2025)
 */
@Getter
public class ColorInfo {
    private int r;
    private int g;
    private int b;
    private double percent;

    @JsonProperty("html_code")
    private String htmlCode;

    @JsonProperty("closest_palette_color")
    private String closestPaletteColor;

    @JsonProperty("closest_palette_color_html_code")
    private String closestPaletteColorHtmlCode;

    @JsonProperty("closest_palette_color_parent")
    private String closestPaletteColorParent;

    @JsonProperty("closest_palette_distance")
    private double closestPaletteDistance;

    @Override
    public String toString() {
        return String.format("      %s      |      %s      |      %f      ", closestPaletteColor, closestPaletteColorParent, percent);

    }
}
