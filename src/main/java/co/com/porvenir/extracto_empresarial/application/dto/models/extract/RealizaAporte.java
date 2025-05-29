package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RealizaAporte {
    @JsonProperty("RealizaAporteAfiliado")
    private String realizaAporteAfiliado;

    @JsonProperty("RealizaAporteEmpleador")
    private String realizaAporteEmpleador;
}
