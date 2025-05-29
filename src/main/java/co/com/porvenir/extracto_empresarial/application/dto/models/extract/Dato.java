package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Dato {
    @JsonProperty("X")
    private String x;

    @JsonProperty("Y")
    private String y;

    @JsonProperty("Color")
    private String color;
}
